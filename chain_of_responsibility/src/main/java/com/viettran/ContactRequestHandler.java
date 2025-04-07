package com.viettran;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Forwarding contact request to relevant department for: " + message.getSenderEmail());
        } else {
            super.handle(message);
        }
    }
}
