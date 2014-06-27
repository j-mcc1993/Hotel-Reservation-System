import java.io.*;
/**
 * An interface for archiving data that needs to be stored when the program exits.
 */
public interface Archivable<T> {
    /**
     * Write the data structure of type T to a file to be stored and unarchived.
     */
    public void writeArchive(T o) throws IOException ;
    
    /**
     * Return object that has been stored in file by the writeArchive(T o) method.
     */
    public T readArchive() throws IOException, ClassNotFoundException;
}