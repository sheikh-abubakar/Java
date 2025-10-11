import java.io.*; // it is a apckage with several classee

public class WriteFile {
    public static void main(String[] args){
        FileWriter fw = null;
        PrintWriter pw = null;
        // true for append
        try{
            fw = new FileWriter("test.txt", true);
            pw = new PrintWriter(fw);

            // fw.write("it can also be ussed for wrting to files without high level nodes\n");

            // String s1 = "hello world";
            // String s2 = "web design";
            String s3 = "  appended word";;
            //write to file
            // pw.println(s1);
            pw.println(s3);
            pw.flush();

            fw.close();
            pw.close();
        }catch(IOException e){
            System.out.println(e);
        }

    }
}