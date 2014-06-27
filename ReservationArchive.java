import java.util.ArrayList;
import java.io.*;

public class ReservationArchive implements Archivable<ArrayList<Reservation>> {
    ArrayList<Reservation> reservation_arr;
    
    public ReservationArchive(){}
    
    public void writeArchive(ArrayList<Reservation> arr) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ReservationArchive.txt"));
        out.writeObject(arr);
        out.close();
    }
    
    /**
     * Because the readArchive() method requires unchecked casting, the compiler throws a warning at compile time.  Since we 
     * already know the data type we are extracting from the file we can safely suppress this warning.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Reservation> readArchive() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("ReservationArchive.txt"));
        reservation_arr = (ArrayList<Reservation>)in.readObject();
        in.close();
        return reservation_arr;
    }
}