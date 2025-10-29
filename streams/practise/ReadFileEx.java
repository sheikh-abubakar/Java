import java.io.*;
import java.util.Scanner;
public class ReadFileEx{
    public static void main(String[] args){
        FileReader fr = null;
        BufferedReader br = null;
        try{
            //creating file reader object

            File obj = new File("test.txt");

            try (Scanner read = new Scanner(obj)){
                while (read.hasNextLine()) {
                    String data = read.nextLine();
                    System.out.println(data);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);

            //reading first line form file
            String line = br.readLine();

            //printing line
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
             // 3. Creation / Last modified time
             System.out.println("Last Modified: " + obj.lastModified());
            fr.close();
            br.close();
        }catch (IOException e){
            System.out.println("File not found");
        }
    }
}