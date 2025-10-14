import java.io.*;


public class DemoObj {
    public static void main(String[] args) {
        String fileName = "demo.txt";
        Person p = new Person("Ali", "BCSF23M511", 42600.0);

        try{
        //lowlevel stream
        FileOutputStream  fis= new FileOutputStream(fileName);
        //high level steam
        ObjectOutputStream oos = new ObjectOutputStream(fis);
        oos.writeObject(p);
        System.out.println("object seriealized to "+ fileName);
        oos.close();
        fis.close();
       }catch(IOException e){
        System.out.println(e);
        e.printStackTrace();
       }
    }
}
