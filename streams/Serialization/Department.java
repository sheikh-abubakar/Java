import java.io.*;

public class Department implements Serializable {
    String name;
    
    public Department(String n){
        this.name = n;
    }

    public String toString(){
        return "studying in department: " + name;
    }
}