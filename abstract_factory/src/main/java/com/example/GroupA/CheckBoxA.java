package com.example.GroupA;

import com.example.CheckBox;

public class CheckBoxA extends CheckBox{
    private boolean checked;

    public CheckBoxA(String text, boolean checked) {
        super(text);
        this.checked = checked;
    }

    @Override
    public void display() {
        System.out.println((checked ? "(X) " : "( ) ") + text);
    }
}
