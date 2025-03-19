package com.example;

import com.example.GroupA.ButtonA;
import com.example.GroupA.CheckBoxA;
import com.example.GroupA.TextFieldA;

public class FactoryA extends UIFactory {
    @Override
    public Button createButton(String text) {
        System.out.println("Creating a Button Type A!");
        return new ButtonA(text);
    }

    @Override
    public CheckBox createCheckBox(String text, Boolean checked) {
        System.out.println("Creating a CheckBox Type A!");
        return new CheckBoxA(text, checked);
    }

    @Override
    public TextField createTextField(String text) {
        System.out.println("Creating a TextField Type A!");
        return new TextFieldA(text);
    }
}
