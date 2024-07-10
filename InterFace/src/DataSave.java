import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSave {
    class SaveActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                FileOutputStream fos = new FileOutputStream("save.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(Main.shape);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
