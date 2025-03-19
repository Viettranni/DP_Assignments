package com.example.GroupA;

import com.example.TextField;

public class TextFieldA extends TextField{

    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("{ " + text + " }");
    }
    
}
