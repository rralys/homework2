import java.io.*;

public class filmsCollectionSave {

    public static void filmsCollectionWrite(filmsCollection collection, String outName) throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream objOut = null;
        try {
            out = new FileOutputStream(outName);
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(collection);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (objOut != null) {
                objOut.close();
            }
        }
    }

    public static filmsCollection filmsCollectionRead(String inName) throws IOException {
        FileInputStream in = null;
        ObjectInputStream objIn = null;
        filmsCollection collection = null;

        try {
            in = new FileInputStream(inName);
            objIn = new ObjectInputStream(in);
            collection = (filmsCollection) objIn.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
            if (objIn != null) {
                objIn.close();
            }
        }

        return collection;
    }
}
