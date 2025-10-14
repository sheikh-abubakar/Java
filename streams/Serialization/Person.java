import java.io.*;

public class Person implements Serializable {
    String name;
    transient String ID;
    Double Fee;

    public Person(String n, String id, Double f){
        this.name = n;
        this.ID = id;
        this.Fee = f;
    }

    public String toString(){
        return "name: " + name + ", id: " + ID + ", fee: "+Fee; 
    }
}
