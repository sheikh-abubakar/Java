import java.net.*;
import java.io.*;

// Socket represents a bidirectional TCP pipe.
public class EchoServer{
    public static void main(String[] args) {
        int port = 5000;
        System.out.println("port: "+port);
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("connection....");
            try{
                Socket cs = ss.accept();
                System.out.println("client cnected to "+ cs.getRemoteSocketAddress());
                try{
                    InputStreamReader ip = new InputStreamReader(cs.getInputStream());
                    BufferedReader in = new BufferedReader(ip);
                    PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

                    String line;

                    line = in.readLine();
                    if(line != null){
                        System.out.println(line);
                        out.println("echo"+line);
                    }
                    System.out.println("closed");
                }catch (Exception e) {
            // TODO: handle exception
        }
            }catch (Exception e) {
            // TODO: handle exception
        }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}