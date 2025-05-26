import java.io.*;
import java.net.*;

public class TCPChatClient {
    public static void main(String[] args) throws IOException {
        try (
            Socket socket = new Socket("localhost", 1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String msg;
            while (true) {
                System.out.print("You: ");
                out.println(console.readLine());
                msg = in.readLine();
                System.out.println("Server: " + msg);
            }
        }
    }
}
