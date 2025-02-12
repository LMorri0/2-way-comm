import java.net.*;
import java.io.*;
import java.nio.Buffer;

public class EchoServer {

    public static void main(String[] args) {
        int portNumber = 7;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String inputLine;
                String inputKeyboardLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client: "+inputLine);
                    inputKeyboardLine = kb.readLine();
                    out.println(inputKeyboardLine);
                }
            }
        } catch(IOException ioe) {
            System.err.println("IO error");
            ioe.printStackTrace();
            System.exit(1);
        }

    }

}
