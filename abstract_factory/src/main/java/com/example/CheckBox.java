package com.example;

public abstract class CheckBox {
    protected String text;

    // Parent Constructor
    public CheckBox(String text) {
        this.text = text;
    }
    
    public abstract void display();
}
