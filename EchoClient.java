import java.net.*;
import java.io.*;
import java.nio.Buffer;

public class EchoClient {
    public static void main(String[] args) {
        String hostName = "localhost";
        int portNumber = 7;

        try {
            Socket echoSocket = new Socket(hostName, portNumber);

            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInputKeyboard;
            String serverInput;
            while((userInputKeyboard = stdIn.readLine()) != null) {
                out.println(userInputKeyboard);
                serverInput = in.readLine();
                System.out.println("Server: " + serverInput);
            }
        } catch(UnknownHostException uhe) {
            System.err.println("unknown host: " + hostName);
            uhe.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            System.err.println("IO error");
            e.printStackTrace();
            System.exit(1);
        }
    }
}