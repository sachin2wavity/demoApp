package com.example.crudapi.CreateModels;

import org.json.JSONArray;

public class ValueModel {
    private String valuetype;
    private String text;
    private boolean rich;
    private long date;
    private int number;
    private JSONArray jsonArray= new JSONArray();

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRich() {
        return rich;
    }

    public void setRich(boolean rich) {
        this.rich = rich;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String name;
    public String value;
}
