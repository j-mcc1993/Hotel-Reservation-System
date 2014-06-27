public class Single extends AbstractRoom {
    public Single() {
        initializeHashMap();
        this.type = "Single";
        this.rnum = 0;
        this.price = 29.99;
    }
    
    public Single(int num) {
        initializeHashMap();
        this.type = "Single";
        this.rnum = num;
        this.price = 29.99;
    }
}