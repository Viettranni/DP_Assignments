package com.example.GroupB;

import com.example.Button;

public class ButtonB extends Button {

    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ " + text + " ]");
    }
}