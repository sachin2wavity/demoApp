package com.example.crudapi.Pojomodels;

public class RecordDataModel {
    private String text ,valueTest;
    private   int age;
   private Long date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValueTest() {
        return valueTest;
    }

    public void setValueTest(String valueTest) {
        this.valueTest = valueTest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
