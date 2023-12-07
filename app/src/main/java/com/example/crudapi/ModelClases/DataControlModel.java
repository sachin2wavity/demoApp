package com.example.crudapi.ModelClases;

import java.util.List;

public class DataControlModel {
    String caption;
    private List<DataTypesModel> dataTypesModelList;
    String id;
    String ctrltype;
    String title;
    Boolean deprecated;



    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public String getTitle() {
        return title;
    }

    public DataControlModel(String caption, String id, String ctrltype, String title, Boolean deprecated) {
        this.caption = caption;
        this.id = id;
        this.ctrltype = ctrltype;
        this.title = title;
        this.deprecated = deprecated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataTypesModel> getDataTypesModelList() {
        return dataTypesModelList;
    }

    public void setDataTypesModelList(List<DataTypesModel> dataTypesModelList) {
        this.dataTypesModelList = dataTypesModelList;
    }

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

    public DataControlModel() {

    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
