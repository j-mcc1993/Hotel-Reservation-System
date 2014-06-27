import java.io.*;
import java.util.HashMap;
/**
 * Abstract class that provides methods for all room objects.
 */
public abstract class AbstractRoom implements java.io.Serializable {
    public String type;
    private static final long serialVersionUID = 100;
    protected int rnum;
    protected double price;
    protected HashMap<String, Boolean> calendar = new HashMap<String, Boolean>(365);

    public int getRmNumber() {
        return this.rnum;
    }

    public double getPrice() {
        return this.price;
    }

    public void setRmNumber(int r) {
        this.rnum = r;
    }

    public String getInfo() {
        String info = new String("    Rm. #: " + rnum + 
                "\nRoom Type: " + type +
                "\n    Price: " + price);
        return info;
    }

    /**
     * Generates a HashMap with dates in the form m/d/y as keys and booleans as values.
     * Keys are of String type, initial size is 365 with dates spanning from 1/1/2014 - 12/31/2014 
     * All boolean values are initialized to false, this method was used to initialize the calendar 
     * for all rooms in the AbstractRoom array.
     */
    public void initializeHashMap() {
        String date = "";
        for (int i = 1; i < 13; i++) {
            date = i+"/";
            if (i==2) {
                for (int x = 1; x<29; x++) {
                    date += x+"/2014";
                    calendar.put(date, false);
                    date = i+"/";
                }
            }
            else if (i==4||i==6||i==9||i==11) {
                for (int y = 1; y < 31; y++) {
                    date += y+"/2014";
                    calendar.put(date, false);
                    date = i+"/";
                }
            } else {
                for (int u = 1; u < 32; u++) {
                    date += u+"/2014";
                    calendar.put(date, false);
                    date = i+"/";
                }
            }
        }
    }

    /**
     * Checks if the calendar has a true value associated with the date being checked, if true the 
     * method returns false to indicate that a room in not available.
     */
    public boolean isAvailable(String date) {
        if (calendar.get(date)) {
            return false;
        }
        return true;
    }
}