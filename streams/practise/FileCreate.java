import java.io.*;

public class FileCreate {
    public static void main(String[] args) {
        
    try{
        File myfile = new File("myfile.txt");
        if(myfile.createNewFile()){
            System.out.println("file creaated");
        }else{
            System.out.println("already exixts");
        }
    }catch(IOException e){
        System.out.println(e);
        e.printStackTrace();
    }    
    }
    
}
