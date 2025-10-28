import java.io.*;
import java.net.*;

public class Server {
    public static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Arithmetic Server starting on port " + PORT + " ...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) { 
                System.out.println("Waiting for a client...");
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                    System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                    while (true) {
                        String expr;
                        try {
                            expr = in.readUTF(); 
                        } catch (EOFException eof) {
                            System.out.println("Client closed connection unexpectedly.");
                            break;
                        }

                        expr = expr == null ? "" : expr.trim();
                        System.out.println("Received: \"" + expr + "\"");

                        if ("exit".equalsIgnoreCase(expr)) {
                            System.out.println("Client requested exit. Closing client connection.");
                            out.writeUTF("Goodbye");
                            out.flush();
                            break; 
                        }

                        // Evaluate expression and respond
                        String response = evaluateExpression(expr);
                        out.writeUTF(response);
                        out.flush();
                        System.out.println("Sent: \"" + response + "\"");
                    }

                } catch (IOException e) {
                    System.err.println("I/O error while handling a client: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server on port " + PORT + ": " + e.getMessage());
        }
    }

    
    private static String evaluateExpression(String expr) {
        if (expr == null || expr.isEmpty()) {
            return "ERROR:Empty expression";
        }

      
        String[] parts = expr.split("\\s+");
        if (parts.length != 3) {
            return "ERROR:Invalid format. Expected: <number> <operator> <number>";
        }

        String leftStr = parts[0];
        String op = parts[1];
        String rightStr = parts[2];

        double left, right;
        try {
            left = Double.parseDouble(leftStr);
            right = Double.parseDouble(rightStr);
        } catch (NumberFormatException nfe) {
            return "ERROR:Invalid number";
        }

        switch (op) {
            case "+":
                return formatResult(left + right);
            case "-":
                return formatResult(left - right);
            case "*":
                return formatResult(left * right);
            case "/":
                if (right == 0.0) {
                    return "ERROR:Division by zero";
                }
                return formatResult(left / right);
            default:
                return "ERROR:Unsupported operator. Use + - * /";
        }
    }

    private static String formatResult(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        } else {
            return String.valueOf(value);
        }
    }
}
