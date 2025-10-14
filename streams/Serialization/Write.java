import java.io.*;

public class Write{
    public static void main(String[] args){
        String fileName = "multipleObj.txt";

        Person p1 = new Person("Ali", "csf23", 750.00);
        Person p2 = new Person("zain", "csf23", 7500.0);
        Department d1 = new Department("computer science");
        Department d2 = new Department("IT");

        try{
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(p1);
            out.writeObject(p2);
            out.writeObject(d1);
            out.writeObject(d2);
            System.out.println("all object written to file!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}