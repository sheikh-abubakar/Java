import java.io.*;
import javax.swing.*;
public class ReadDemo {
    public static void main(String[] args) {
        String fileName = "demo.txt";
        try {
            FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream os = new ObjectInputStream(is);  
            
            Person p1 = (Person) os.readObject();
            // JOptionPane.showMessageDialog(null, p1);
            
            FileOutputStream fos = new FileOutputStream("op.txt");
            PrintStream out = new PrintStream(fos);

            System.setOut(out);
            System.out.println(p1);
            os.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}