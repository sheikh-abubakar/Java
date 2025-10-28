import java.io.*;
import java.net.*;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Connecting to server " + HOST + ":" + PORT + " ...");

        try (Socket socket = new Socket(HOST, PORT);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected. Type an expression like: 12 + 5");
            System.out.println("Type 'exit' to quit.");

            while (true) {
                System.out.print("Enter expression: ");
                String line = console.readLine();
                if (line == null) { 
                    break;
                }
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Send expression to server
                out.writeUTF(line);
                out.flush();

             
                if ("exit".equalsIgnoreCase(line)) {
                    String serverMsg = in.readUTF();
                    System.out.println("Server: " + serverMsg);
                    System.out.println("Disconnected.");
                    break;
                }

                // Read response from server
                String response = in.readUTF();

              
                if (response != null && response.startsWith("ERROR:")) {
                    System.out.println("Invalid expression");
                    
                } else {
                    System.out.println("Result: " + response);
                }
            }

        } catch (ConnectException ce) {
            System.err.println("Connection refused. Is the server running on " + HOST + ":" + PORT + "?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
