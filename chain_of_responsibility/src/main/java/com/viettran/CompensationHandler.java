package com.viettran;

public class CompensationHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("Processing compensation claim from: " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
        } else {
            super.handle(message);
        }
    }
}
