package com.example;

import com.example.GroupB.ButtonB;
import com.example.GroupB.CheckBoxB;
import com.example.GroupB.TextFieldB;

public class FactoryB extends UIFactory{
    @Override
    public Button createButton(String text) {
        System.out.println("Creating a Button Type B!");
        return new ButtonB(text);
    }

    @Override
    public CheckBox createCheckBox(String text, Boolean checked) {
        System.out.println("Creating a CheckBox Type B!");
        return new CheckBoxB(text, checked);
    }

    @Override
    public TextField createTextField(String text) {
        System.out.println("Creating a TextField Type B!");
        return new TextFieldB(text);
    }
}
