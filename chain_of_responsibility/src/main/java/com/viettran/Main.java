package com.viettran;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler suggestion = new SuggestionHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        // Chain the handlers
        compensation.setNextHandler(contact);
        contact.setNextHandler(suggestion);
        suggestion.setNextHandler(general);

        // Creating different messages for different handling types
        Message m1 = new Message(MessageType.COMPENSATION, "I would like a refund for my broken product.", "user1@gmail.com");
        Message m2 = new Message(MessageType.CONTACT_REQUEST, "Please call me about my order.", "user2@gmail.com");
        Message m3 = new Message(MessageType.SUGGESTION, "It would be great if you could add a dark mode.", "user3@gmail.com");
        Message m4 = new Message(MessageType.GENERAL_FEEDBACK, "It was a Great service overall!", "user4@gmail.com");

        // Process messages by passing the message first to the first handler
        compensation.handle(m1);
        compensation.handle(m2);
        compensation.handle(m3);
        compensation.handle(m4);
    }
}
