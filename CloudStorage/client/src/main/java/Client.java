import java.io.*;
import java.net.Socket;

public class Client {

    private final String SERVER_Address = "localhost";
    private final int SERVER_PORT = 503;
    private DataInputStream in;
    private DataOutputStream out;
    private DataInputStream incomeMsg;
    private DataOutputStream send;
    private BufferedReader text;
    private Socket socket;

    public static void main(String[] args) throws IOException {

        new Client().runClient();
    }

    public void runClient()  {

        try {
            socket = new Socket(SERVER_Address, SERVER_PORT);        // подключаемся к серверу
            text = new BufferedReader(new InputStreamReader(System.in));
            in = new DataInputStream(socket.getInputStream()); // запрос у сокета для передачи данных в сторону сервака
            out = new DataOutputStream(socket.getOutputStream());  // запрос у сокета на приём данных с сервера
            System.out.println("-= Client connecting to server =-");   // при успешном подключении видим данную надпись

            Thread outcome = new Thread(()-> {    // создаём поток на отправку комманд на сервак
                try {
                    sendMsg();  // метод отправки сообщений
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread income = new Thread(()-> {   // создаём поток на прослушку сервака
                try {
                    acceptMsg();  // метод на считывание сообщений
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            outcome.start();    // запуск потока

            income.start();     // запуск потока

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() throws IOException {  // метод отправки сообщений (комманд)

        while (!socket.isOutputShutdown()) {
            if (text.ready()) {
                String textToServer = text.readLine();
                out.writeUTF(textToServer);
                System.out.println("Client send msg: " + textToServer);
                if (textToServer.equals("/disconnect")) {
                    System.out.println("Connection lost");
                    break;
                }
            }
        }
    }

    public void acceptMsg () throws IOException, InterruptedException {  // метод на считывание сообщений

        incomeMsg = new DataInputStream(socket.getInputStream());
//        send = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String messageFromServer = incomeMsg.readUTF();
            Thread.sleep(1000);
            System.out.println("Server take message from client: " + messageFromServer);
            if (messageFromServer.equals("/disconnect")) {
                System.out.println("Client disconnect");
                break;
            }
        }
    }
}