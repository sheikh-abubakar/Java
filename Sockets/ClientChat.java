// ClientChat.java
import java.io.*;
import java.net.*;

public class ClientChat {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;
        System.out.println("Connecting to " + host + ":" + port + " ...");
        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server.");

            // Listener thread: prints messages received from server
            Thread listener = new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println("[Server] " + line);
                        if ("bye".equalsIgnoreCase(line.trim())) {
                            System.out.println("Server sent bye. Closing listener.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Listener stopped: " + e.getMessage());
                }
            });
            listener.start();

            // Main thread: read from keyboard and send to server
            String msg;
            while ((msg = keyboard.readLine()) != null) {
                out.println(msg); // send
                if ("bye".equalsIgnoreCase(msg.trim())) {
                    System.out.println("You sent bye. Closing connection.");
                    break;
                }
            }

            // ensure listener ends
            listener.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Client stopped.");
    }
}
