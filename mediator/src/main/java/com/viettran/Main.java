package com.viettran;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Creating the mediator
        ChatMediator mediator = new ChatMediatorImpl();

        // Initializing the clients and register them with the mediator
        ChatClientController client1 = new ChatClientController("Viet", mediator);
        ChatClientController client2 = new ChatClientController("Saed", mediator);
        ChatClientController client3 = new ChatClientController("Spiderman", mediator);

        // Register the clients with the mediator
        mediator.registerClient(client1);
        mediator.registerClient(client2);
        mediator.registerClient(client3);

        // Show the UIs after all clients are registered
        client1.showUI();
        client2.showUI();
        client3.showUI();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
