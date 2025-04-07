package com.viettran;

public class SuggestionHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.SUGGESTION) {
            System.out.println("Logging development suggestion: " + message.getContent());
        } else {
            super.handle(message);
        }
    }
}
