public class Customer implements java.io.Serializable {
    private static final long serialVersionUID = 50;
    protected String name;
    protected String phoneNumber;
    private String email;
    
    public Customer() {
        this.name = null;
        this.phoneNumber = null;
        this.email = null;
    }
    
    public Customer(String name, String number, String email) {
        this.name = name;
        this.phoneNumber = number;
        this.email = email;
    }
    
    public String getInfo() {
        String info = new String("  Name: " + name +
        "\nPhone #: "+ phoneNumber + 
        "\n E-Mail: " + email);
        return info;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    public void setPhoneNumber(String n) {
        this.phoneNumber = n;
    }
    
    public void setEmailAddress(String e) {
        this.email = e;
    }
}