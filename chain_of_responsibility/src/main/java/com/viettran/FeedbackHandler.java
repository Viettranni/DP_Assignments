package com.viettran;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler handler) {
        this.nextHandler = handler;
    }

    public void handle(Message message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler found for message type: " + message.getType());
        }
    }
}
