import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args){
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Line1" + "\n");
            writer.write("Line2" + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
