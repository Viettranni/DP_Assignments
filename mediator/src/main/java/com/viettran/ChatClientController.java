package com.viettran;

public class ChatClientController {
    private String username;
    private ChatMediator mediator;
    private ChatClientUI chatClientUI;

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        this.chatClientUI = new ChatClientUI(this, username);
        mediator.registerClient(this);
    }

    public void showUI() {
        chatClientUI.show();
        chatClientUI.updateRecipientList(); 
    }

    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(username, recipient, message);
        chatClientUI.displayMessage("To " + recipient + ": " + message);
    }

    public void receiveMessage(String sender, String message) {
        chatClientUI.displayMessage("From " + sender + ": " + message);
    }

    public String getUsername() {
        return username;
    }

    public ChatMediator getMediator() {
        return mediator;
    }
}
