import java.io.*;
import java.net.*;

public class EchoClient{
    public static void main(String[] args) {
        String IP = "localhost";
        int port = 5000;
        try(Socket cs = new Socket(IP, port)){
            InputStreamReader ip = new InputStreamReader(cs.getInputStream());
            BufferedReader in= new BufferedReader(ip);
            PrintWriter pw = new PrintWriter(cs.getOutputStream(), true);//with true flush auto
            
            System.out.println("clinet connected to server at a : "+IP+" "+port);
            // send msg
            String msg = "hey dear server!";
            pw.println("sending: "+msg);
            
            //read reply
            String reply = in.readLine();
            System.out.println("reply: "+reply);
            cs.close();
            in.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}