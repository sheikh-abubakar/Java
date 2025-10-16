import java.util.ArrayList;

class Student{
    String name;
    int age;

    public Student(String n, int a){
        this.name = n;
        this.age = a;
    }

    public String toString(){
        return "name: "+name + "  age "+age;
    }
}

public class StdClass {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("abuabkaar", 10));
        list.add(new Student("zain", 10));

        for(Student s: list){
            System.out.println(s);
        }

    }
    
}