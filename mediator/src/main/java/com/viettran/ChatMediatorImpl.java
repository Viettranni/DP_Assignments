package com.viettran;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private List<ChatClientController> clients = new ArrayList<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.add(client);
    }

    @Override
    public void sendMessage(String sender, String receiver, String message) {
        for (ChatClientController client : clients) {
            if (client.getUsername().equals(receiver)) {
                client.receiveMessage(sender, message); 
                break;
            }
        }
    }

    @Override
    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList<>();
        for (ChatClientController client : clients) {
            usernames.add(client.getUsername());
        }
        return usernames;
    }
}
