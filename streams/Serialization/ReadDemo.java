import java.io.*;

public class ReadDemo {
    public static void main(String[] args) {
        String fileName = "demo.txt";
        try {
            FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream os = new ObjectInputStream(is);  
            
            Person p1 = (Person) os.readObject();
            System.out.println("object deserialized: " + p1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}