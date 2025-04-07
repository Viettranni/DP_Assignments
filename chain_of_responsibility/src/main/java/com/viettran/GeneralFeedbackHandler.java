package com.viettran;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("Analyzing general feedback: " + message.getContent());
        } else {
            super.handle(message);
        }
    }
}
