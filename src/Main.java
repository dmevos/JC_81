import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        System.out.println("Запустили сервер");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // ждем подключения
                try ( PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
){
                System.out.printf("Принято новое соединенение. Порт: %d%n", clientSocket.getPort());
                String name = in.readLine();
                out.println(String.format("Привет %s, твой порт: %d", name, clientSocket.getPort()));}
            }
        }
    }
}