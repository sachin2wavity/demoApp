package com.example.crudapi.CreateModels;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DatatypeModel {
    private String id;
    private String type;
    private String subtype;
    private List<JSONObject> values = new ArrayList<>();

    public List<JSONObject> getValue() {
        return values;
    }

    public void setValue(List<JSONObject> value) {
        this.values = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", values=" + values +
                '}';
    }
}
