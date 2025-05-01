package com.viettran;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientUI {
    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientSelector;
    private Button sendButton;
    private ChatClientController controller;

    public ChatClientUI(ChatClientController controller, String username) {
        this.controller = controller;
        chatArea = new TextArea();
        chatArea.setEditable(false);
        messageField = new TextField();
        recipientSelector = new ComboBox<>();
        sendButton = new Button("Send");

        sendButton.setOnAction(e -> {
            String recipient = recipientSelector.getValue(); 
            String message = messageField.getText();  
            if (recipient != null && !message.trim().isEmpty()) {
                controller.sendMessage(recipient, message);
                messageField.clear(); 
            }
        });

        VBox vbox = new VBox(10, chatArea, recipientSelector, messageField, sendButton);
        Scene scene = new Scene(vbox, 400, 300);

        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(scene);
        stage.show();
    }

    public void updateRecipientList() {
        recipientSelector.getItems().clear();

        controller.getMediator().getAllUsernames().forEach(name -> {
            if (!name.equals(controller.getUsername())) {
                if (!recipientSelector.getItems().contains(name)) {
                    recipientSelector.getItems().add(name);
                }
            }
        });
    }

    public void displayMessage(String message) {
        chatArea.appendText(message + "\n");
    }

    public void show() {
    }
}
