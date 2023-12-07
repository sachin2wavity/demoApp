package com.example.crudapi.CreateModels;

import java.util.ArrayList;

public class RootCreateModel {
    private String application;
    private String state;
    private ArrayList<FormModel> forms;
    private int latitude;
    private int longitude;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getState() {
        return state;
    }

    public void setState(String status) {
        this.state = status;
    }

    public ArrayList<FormModel> getForms() {
        return forms;
    }

    public void setForms(ArrayList<FormModel> forms) {
        this.forms = forms;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{" +
                "application='" + application + '\'' +
                ", state='" + state + '\'' +
                ", forms=" + forms +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
