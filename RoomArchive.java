import java.io.*;

public class RoomArchive implements Archivable<AbstractRoom[]> {
    AbstractRoom[] roomArr;

    public RoomArchive() {}

    public void writeArchive(AbstractRoom[] arr) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("RoomArchive.txt"));
        out.writeObject(arr);
        out.close();
    }
    
    /**
     * Because the readArchive() method requires unchecked casting, the compiler throws a warning at compile time.  Since we 
     * already know the data type we are extracting from the file we can safely suppress this warning.
     */
    @SuppressWarnings("unchecked")
    public AbstractRoom[] readArchive() throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("RoomArchive.txt"));
        roomArr = (AbstractRoom[])in.readObject();
        in.close();
        return roomArr;
    }
}