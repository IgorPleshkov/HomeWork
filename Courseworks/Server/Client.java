package Courseworks.Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private Socket socket;
    private Connection connection;

    public Client(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
        socket = new Socket(ip, port);
    }

    public void start() throws Exception {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        while (name.trim().length() <= 2){
            System.out.println("Имя д.б. больше 2-х символов!");
            name = scanner.nextLine();
        }
        connection = new Connection(socket);
        String message;

        Thread reader = new Thread(new Reader());
        reader.setDaemon(true);
        reader.start();

        while (true) {
            Thread.sleep(1000);
            System.out.println("Введите сообщение, для выхода введите exit: ");
            message = scanner.nextLine();
            connection.sendMessage(Message.getMessage(name, message));
            if (message.equals("exit")) {
                System.out.println("Отключение...");
                break;
            }
        }
    }

    class Reader implements Runnable {

        @Override
        public void run() {
            Message fromServer = null;
            while (true) {
                try {
                    fromServer = connection.readMessage();
                    System.out.println("От сервера: " + fromServer);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Client("127.0.0.1", 8090).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
