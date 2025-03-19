package com.example;

public abstract class TextField {
    protected String text;

    // Parent Constructor
    public TextField(String text) {
        this.text = text;
    }
    
    public abstract void display();
}
