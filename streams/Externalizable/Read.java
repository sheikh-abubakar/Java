import java.io.*;

public class Read{
    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream("test.txt");
            ObjectInputStream ois = new ObjectInputStream(is);

            Student s = (Student) ois.readObject();
            ois.close();

            System.out.println(s);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}