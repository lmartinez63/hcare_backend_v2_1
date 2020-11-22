package com.landl.hcare.entity;

public class AutoCompleteField {

    String text;

    Object value;

    public AutoCompleteField() {
    }

    public AutoCompleteField(String text, Object value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}