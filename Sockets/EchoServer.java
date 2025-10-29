import java.net.*;
import java.io.*;

// Socket represents a bidirectional TCP pipe.
// to read data

// InputStream input = socket.getInputStream();  

// to send data

// OutputStream output = socket.getOutputStream();

// ServerSocket: This socket waits for incoming client requests. It listens for connections on a specific port.


// Socket: Once a connection is established, the server uses this socket to communicate with the client.

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
                System.out.println("client cnected to "+ cs.getInetAddress());
                System.out.println("server cnected to "+ cs.getLocalAddress());
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
                    ss.close();
                    in.close();
                
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