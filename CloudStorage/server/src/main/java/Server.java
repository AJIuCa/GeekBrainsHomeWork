// 1. Как организовать клиент-серверное взаимодействие?
//       Через Java.oi, java.net.Socket. Скорей всего Netty так как он проходится на данном курсе.

// 2. Как и в каком виде передавать файлы?
//       Передача потока байтов

// 3. Как пересылать большие файлы?
//          Дробить большие файлы на части.

// 4. Как пересылать служебные команды?
//      Использоватль скорей всего хэндлер на команды

// 5. Что хранить в базе данных?
//          Данные пользователя, логин и пасс для авторизации. Использовать MySql

// 6. Как передавать структуру каталогов/файлов?
//          Через Path

// 7. Какую библиотеку использовать для сетевого взаимодействия: java.io, java.nio, Netty?
//           Все




import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private DataInputStream acceptMsg;


    public static void main(String[] args) {

        new Server().runServer();

    }

    // Запускаем сервак

    public void runServer() {

        try (ServerSocket serverSocket = new ServerSocket(503)) {       // порт выбран рандомно
            System.out.println
                    ("\n-= Starting server (local port = " + serverSocket.getLocalPort() + "). Waiting for connection =-"); // приветствие от сервака
            socket = serverSocket.accept();             // ожидаем подключений
            System.out.println(" -= Client connected =-");

            Thread thread1 = new Thread(() -> {         // запуск потока, который будет принимать команды отправленные на сервак
                try {
                    acceptCommands();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread thread2 = new Thread(() -> {     // задел на будущие потоки со своими командами

            });

            thread1.start();
//            thread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void acceptCommands() throws IOException {

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        while (true) {

            String message = in.readUTF();
            System.out.println("Server take message from client: " + message);    // чтение команд от клиента
            if (message.equals("/disconnect") || message.equals("/exit") || message.equals("/quit")) {
                System.out.println("Client disconnect");
                break;
            }
            System.out.println("Server Wrote message to client: " + message);    // сервер дублирует команды клиента, созданн блок для проверки, что входящие сообщения проходят
            out.writeUTF(message);

        }
    }

}
