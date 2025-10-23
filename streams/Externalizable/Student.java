import java.io.*;

public class Student implements Externalizable {
    String name;
    int age;
    double marks;

    public Student(){
        System.out.println("default ctor called!");
    }

    public Student(String n, int a, double m){
        this.name = n;
        this.age = a;
        this.marks = m;
    }

    // manual Serialaization
    
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("custom write external called");
        out.writeObject(name);
        out.writeInt(age);
        out.writeDouble(marks);//if you skipped it 
    }

    // Manual desririal..
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        System.out.println("custom readexternal..");
        name = (String) in.readObject();
        age = in.readInt();
        marks = 0.0;// if skipped in write external the it will treat it as transient
        marks = in.readDouble();//if you not skiiped it in writeextrenal , it is mandatory
    }

    public String toString(){
        return name +  " " + " " + age + " " + marks;
    }
}
