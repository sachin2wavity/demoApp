package com.example.crudapi.CreateModels;

import java.util.ArrayList;

public class FormModel {
    private String id;
    private ArrayList<DatacontrolModel> datacontrols;
    private ArrayList<Object> sections;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<DatacontrolModel> getDatacontrols() {
        return datacontrols;
    }

    public void setDatacontrols(ArrayList<DatacontrolModel> datacontrols) {
        this.datacontrols = datacontrols;
    }

    public ArrayList<Object> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Object> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", datacontrols=" + datacontrols +
                ", sections=" + sections +
                '}';
    }
}
