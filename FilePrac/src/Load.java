import java.io.*;

public class Load {
    public static void main(String[] args){
        try {
            File file = new File("save.dat");
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Person p = (Person) ois.readObject();
                System.out.println(p);
                ois.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
