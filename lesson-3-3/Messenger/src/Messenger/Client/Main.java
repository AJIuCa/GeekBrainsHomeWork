package Messenger.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.RandomAccessFile;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JustAnotherMessenger");
        primaryStage.setScene(new Scene(root, 690, 590));
        primaryStage.show();

//        DataOutputStream outputStream = new DataOutputStream();
//        outputStream.writeInt(1);
//        outputStream.writeUTF("gfgf");
//
//        DataInputStream inputStream  = new DataInputStream();
//        inputStream.readInt();
//        inputStream.readUTF();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
