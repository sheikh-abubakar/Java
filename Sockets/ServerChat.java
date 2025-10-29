// ServerChat.java
import java.io.*;
import java.net.*;

public class ServerChat {
    public static void main(String[] args) {
        int port = 5000;
        System.out.println("Server starting on port " + port + " ...");
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket client = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Client connected: " + client.getInetAddress() + ":" + client.getPort());

            // Listener thread: prints messages received from client
            Thread listener = new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println("[Client] " + line);
                        if ("bye".equalsIgnoreCase(line.trim())) {
                            System.out.println("Client sent bye. Closing listener.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Listener stopped: " + e.getMessage());
                }
            });
            listener.start();

            // Main thread: read from keyboard and send to client
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
        System.out.println("Server stopped.");
    }
}
