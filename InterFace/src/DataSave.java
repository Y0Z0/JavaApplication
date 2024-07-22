import java.io.*;
import java.util.List;

public class DataSave {
    public static void saveShapes(List<Design.Drawable> shapes, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(shapes);
            System.out.println("Shapes saved to " + "save.data");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Design.Drawable> loadShapes(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Design.Drawable> shapes = (List<Design.Drawable>) in.readObject();
            System.out.println("Shapes loaded from " + "save.data");
            return shapes;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
