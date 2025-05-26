import java.io.*;
import java.net.*;

public class TCPChatServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started. Waiting for client...");

            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Client connected.");

                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Client: " + msg);
                    System.out.print("You: ");
                    out.println(console.readLine());
                }
            }
        }
        
    }
}
