package com.viettran;

import java.util.List;

public interface ChatMediator {
    void registerClient(ChatClientController client);
    void sendMessage(String sender, String receiver, String message);
    List<String> getAllUsernames();
}
