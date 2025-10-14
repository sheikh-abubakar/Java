import java.io.*;

public class Read{
    public static void main(String[] args){
        try{
            FileInputStream ip = new FileInputStream("multipleObj.txt");
            ObjectInputStream ois = new ObjectInputStream(ip);
            while (true) {
                Object obj = ois.readObject();
                if(obj instanceof Person ){
                    System.out.println(obj);
                }else if(obj instanceof Department){
                    System.out.println(obj);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}