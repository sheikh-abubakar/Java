import java.io.*;

class Write {
    public static void main(String[] args) {
        Student s = new Student("Ali", 20, 20.0);

        try {
            FileOutputStream fos = new FileOutputStream("test.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);

            os.writeObject(s);
            os.close();
            System.out.println("writed!");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}