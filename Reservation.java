public class Reservation implements java.io.Serializable {
    private static final long serialVersionUID = 150;
    protected Customer customer;
    protected AbstractRoom room;
    protected String[] date;
    
    public Reservation() {
        this.customer = null;
        this.room = null;
        this.date = null;
    }
    
    public Reservation(Customer c, AbstractRoom r, String[] arr) {
        this.date = arr;
        for (int i = 0; i < arr.length; i++) {
            r.calendar.put(arr[i], true);
        }
        this.customer = c;
        this.room = r;
    }
    
    public String getInfo() {
        String info = new String("     Name: " + customer.name +
        "\nRm. type: " + room.type +
        "\n     Rm. #: " + room.rnum +
        "\n      Price: $" + room.price + " per night" +
        "\n   Date(s): " + date[0] + "-" + date[date.length-1]);
        return info;
    }
}