import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class HotelManager {
    int search_pos2;
    int search_pos3;
    int search_pos4;
    static Archivable archiver;
    static AbstractRoom[] room_list;
    static ArrayList<Reservation> reservation_list;
    
    public static void main(String[] args) {
        room_list = new AbstractRoom[20];
        reservation_list = new ArrayList<Reservation>();
        for (int i = 0; i < room_list.length; i++) {
            if (i < 5) {
                room_list[i] = new Single(100 + i);
            }
            else if (i < 10) {
                room_list[i] = new Double(200 + (i-5));
            }
            else if (i < 15) {
                room_list[i] = new Suite(300+(i-10));
            }
            else if (i < 20) {
                room_list[i] = new Honeymoon(400+(i-15));
            }
        }
        close();
    }
    
    public HotelManager() {
        initialize();
    }
    
    public Reservation getReservation(String name, String phone, int room_num) {
        Iterator<Reservation> iter = reservation_list.iterator();
        while (iter.hasNext()) {
            Reservation temp = iter.next();
            if (temp.customer.name.equals(name) && temp.customer.phoneNumber.equals(phone) && temp.room.rnum == room_num) {
                return temp;
            }
        }
        return null;
    }
    
    public String displayReservationList() {
        String output = "";
        Iterator<Reservation> iter = reservation_list.iterator();
        while (iter.hasNext()) {
            output += iter.next().getInfo() + "\n\n";
        }
        return output;
    }
    
    public String addReservation(String name, String phone, String email, String type, String date, int nights) {
        Reservation r = new Reservation();
        Customer c = new Customer(name, phone, email);
        String[] meta_data = nextAvailable(type, date, 7, nights).split(":");
        int room_num;
        String temp_date = meta_data[1];
        room_num = Integer.parseInt(meta_data[0]);
        r.date = new String[nights];
        for (int i = 0; i < r.date.length; i++) {
            r.date[i] = temp_date;
            temp_date = getNextDate(temp_date);
        }
        Reservation temp = new Reservation(c, getRoom(room_num), r.date);
        reservation_list.add(temp);
        reservation_list.trimToSize();
        r = null;
        return temp.getInfo();
    }
    
    public AbstractRoom getRoom(int room_num) {
        for (int i = 0; i < room_list.length; i++) {
            if (room_list[i].rnum == room_num) {
                return room_list[i];
            }
        }
        return null;
    }

    public static void deleteReservation(Reservation r) {
        for (int i = 0; i < room_list.length; i++)  {
            if (r.room.rnum == room_list[i].rnum) {
                for (int u = 0; u < r.date.length; u++) {
                    room_list[i].calendar.put(r.date[u], false);
                }
            }
        }
        reservation_list.remove(r);
        reservation_list.trimToSize();
        r = null;
    }

    /**
     * Finds the earliest date when a type of room will be available for the specifed time range.
     * 
     * @param type the type of room to check
     * @param date desired starting date
     * @param range number of days in the future to check availability
     * @param nights number of nights of desired reservation
     * @return a string with the room number and date of next available room and time
     */
    public String nextAvailable(String type, String date, int range, int nights) {
        int start = 0; 
        int length = room_list.length;
        int search_pos2 = length/4;
        int search_pos3 = length/2;
        int search_pos4 = (3*length)/4;
        //Check which index of room_list to start searching
        if (type.equals("Single")) start = 0;
        if (type.equals("Double")) start = search_pos2;
        if (type.equals("Suite")) start = search_pos3;
        if (type.equals("Honeymoon Suite")) start = search_pos4;

        for (int i = start; i < start+search_pos2; i++) {  //iterate over rooms of a specific type
            String temp = date;  //temporary date to verify range of availablity
            if (room_list[i].isAvailable(date)) { 
                //if room is available on this date and only requested for one night, return data
                if (nights == 1) return room_list[i].rnum + ":" + date;
                //checks if room is available during the upcoming nights
                for (int u = 1; u < nights; u++) { 
                    temp = getNextDate(temp);
                    //if room is unvailable break out of loop and iterate to next room
                    if (!room_list[i].isAvailable(temp)) break;
                    //u will = nights-1 if room is available for the specified number of nights
                    if (u == nights-1) return room_list[i].rnum + ":" + date;
                }
            }
        }
        //This method will repeat itself for as many times as the range variable will allow if all
        //the rooms of a particular type are occupied during the chosen time range, this allows the
        //method to find the soonest available time slot for the appropriate room type.
        if (range != 0) {
            range -= 1;
            return nextAvailable(type, getNextDate(date), range, nights);
        }
        return null;
    }

    /**
     * A method to handle iterating over dates stored as String objects.
     * 
     * @param date starting date
     * @return date directly following the starting date
     */
    public String getNextDate(String date) {
        if (date.equals("1/1/2015")) return null;
        String response = ""; //this is the string returned by the method
        String[] arr = date.split("\\/"); //grab the individual digits so they can be parsed to integers
        int day_num = 0;
        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);
        //This block checks how many days are in the month of this particular date and assigns it
        //to the day_num integer
        if (month == 2) {
            day_num = 29;
        }
        else if (month==4||month==6||month==9||month==11) {
            day_num = 31;
        } else {
            day_num = 32;
        }
        //this block checks if it is the last day of the month (or if it is the last day of December)
        //and returns the appropriate response string
        if ((day+1) == day_num) {
            if (month == 12) {
                return "1/1/2015";
            } else {
                response = (month+1) + "/1/2014";
                return response;
            }
        } else {
            response = month + "/" + (day+1) + "/2014";
            return response;
        }
    }

    /**
    * Generates reservation_list and room_list from their respective archive files.
    */
    @SuppressWarnings("unchecked")
    public static final void initialize() {
        try {
            archiver = new RoomArchive();
            room_list = (AbstractRoom[])archiver.readArchive();

            archiver = new ReservationArchive();
            reservation_list = (ArrayList<Reservation>)archiver.readArchive();
            reservation_list.trimToSize();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
    * Updates archive files with data from room_list and reservation_list, this ensures that any data
    * stored in the room objects (like the calendar) will maintain their current state after the 
    * program has restarted.
    */
    @SuppressWarnings("unchecked")
    public static final void close() {
        try {
            archiver = new RoomArchive();
            archiver.writeArchive(room_list);

            archiver = new ReservationArchive();
            archiver.writeArchive(reservation_list);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}