
public class Double extends AbstractRoom {
    public Double() {
        initializeHashMap();
        this.type = "Double";
        this.rnum = 0;
        this.price = 39.99;
    }
    
    public Double(int num) {
        initializeHashMap();
        this.type = "Double";
        this.rnum = num;
        this.price = 39.99;
    }
}