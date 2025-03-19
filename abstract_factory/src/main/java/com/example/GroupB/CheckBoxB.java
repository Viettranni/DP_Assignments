package com.example.GroupB;

import com.example.CheckBox;

public class CheckBoxB extends CheckBox{
    private boolean checked;

    public CheckBoxB(String text, boolean checked) {
        super(text);
        this.checked = checked;
    }

    @Override
    public void display() {
        System.out.println("[" + (checked ? "✓" : " ") + "] " + text);
    }
}