
public class Suite extends AbstractRoom {
    public Suite() {
        initializeHashMap();
        this.type = "Suite";
        this.rnum = 0;
        this.price = 49.99;
    }
    
    public Suite(int num) {
        initializeHashMap();
        this.type = "Suite";
        this.rnum = num;
        this.price = 49.99;
    }
}