public class Honeymoon extends AbstractRoom {
    public Honeymoon() {
        initializeHashMap();
        this.type = "Honeymoon Suite";
        this.rnum = 0;
        this.price = 44.99;
    }
    
    public Honeymoon(int num) {
        initializeHashMap();
        this.type = "Honeymoon Suite";
        this.rnum = num;
        this.price = 44.99;
    }
}