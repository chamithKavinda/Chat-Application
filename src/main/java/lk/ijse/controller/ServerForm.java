package lk.ijse.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerForm {

    @FXML
    private TextArea txtServerArea;

    @FXML
    private TextField txtServerField;

    ServerSocket serverSocket;
    Socket socket;

    DataInputStream inputStream;
    DataOutputStream outputStream;

    String message="";
    String reply="";

    public void initialize(){

        Thread initialThread = new Thread(()->{
            try {
                serverSocket = new ServerSocket(3030);
                socket = serverSocket.accept();

                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());


                while (!message.equals("finish")){
                    message = inputStream.readUTF();

                    Platform.runLater(()->{
                        txtServerArea.setText(txtServerArea.getText()+"\n"+message);
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        initialThread.start();
    }


    @FXML
    void btnSSendOnAction(ActionEvent event) throws IOException {
        outputStream.writeUTF(txtServerField.getText());
        outputStream.flush();
    }

}
