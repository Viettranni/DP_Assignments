package com.example;

public abstract class Button {
    protected String text;

    // Parent Constructor
    public Button(String text) {
        this.text = text;
    }

    public abstract void display();
}
