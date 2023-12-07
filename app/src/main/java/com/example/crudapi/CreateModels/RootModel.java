package com.example.crudapi.CreateModels;

import java.util.ArrayList;

public class RootModel {
    private String recordid;
    private String application;
    private String state;
    private String status;
    private ArrayList<FormModel> forms;
    private int latitude;
    private int longitude;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }


    @Override
    public String toString() {
        return "{" +
                "id='" + recordid + '\'' +
                ",application='" + application + '\'' +
                ",status='" + status + '\'' +
                ",state='" + state + '\'' +
                ",forms=" + forms +
                ",latitude=" + latitude +
                ",longitude=" + longitude +
                '}';
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
