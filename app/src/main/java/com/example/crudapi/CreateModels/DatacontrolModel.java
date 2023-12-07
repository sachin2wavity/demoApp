package com.example.crudapi.CreateModels;

import java.util.ArrayList;

public class DatacontrolModel {
    private String id;
    private String ctrltype;
    private ArrayList<DatatypeModel> datatypes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCtrltype() {
        return ctrltype;
    }

    public void setCtrltype(String ctrltype) {
        this.ctrltype = ctrltype;
    }

    public ArrayList<DatatypeModel> getDatatypes() {
        return datatypes;
    }

    public void setDatatypes(ArrayList<DatatypeModel> datatypes) {
        this.datatypes = datatypes;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", ctrltype='" + ctrltype + '\'' +
                ", datatypes=" + datatypes +
                '}';
    }
}
