import java.io.*;
import java.util.*;

class Student implements Serializable{
    String name;
    int age;
    public Student(String n, int a){
        this.name = n;
        this.age = a;
    }

    public String toString(){
        return name + "   " + age;
    }
}

public class Serialized {
    public static void main(String[] args) {
        ArrayList<Student> s = new ArrayList<>();

        s.add(new Student("ali", 0));
        s.add(new Student("ali", 0));
        try{
            FileOutputStream fos = new FileOutputStream("test.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            System.out.println("saved!");
            os.writeObject(s);
            os.close();
        }catch(Exception e){
            System.out.println(e);
        }
        

        try {
            FileInputStream fis = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        s = (ArrayList<Student>)ois.readObject();
        System.out.println(s);
        ois.close();
        } catch (Exception e) {
            System.out.println(e);
        }
       


        
    }
    
}