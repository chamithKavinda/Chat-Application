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

public class ClientForm {

    @FXML
    private TextArea txtClientArea;

    @FXML
    private TextField txtClientField;

    ServerSocket serverSocket;
    Socket socket;

    DataInputStream inputStream;
    DataOutputStream outputStream;

    String message="";
    String reply="";

    public void initialize(){
        new Thread(()->{
            try {
                socket = new Socket("localhost",3030);

                while (!message.equals("finish")){
                    inputStream = new DataInputStream(socket.getInputStream());
                    outputStream = new DataOutputStream(socket.getOutputStream());
                    message = inputStream.readUTF();

                    Platform.runLater(()->{
                        txtClientArea.setText(txtClientArea.getText()+"\n"+message);
                    });
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    void btnSendOnAction(ActionEvent event) throws IOException {
        outputStream.writeUTF(txtClientArea.getText());
        outputStream.flush();
    }

}
