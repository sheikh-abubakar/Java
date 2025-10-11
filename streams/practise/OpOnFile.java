import java.io.*;
// to show output on file rather than on console use file outputStream with setout function
public class OpOnFile{
    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintStream ps = new PrintStream(fos);

        System.setOut(ps);

        System.out.println("heelo ");

        ps.close();
    }
}