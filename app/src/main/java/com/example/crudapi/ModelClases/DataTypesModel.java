package com.example.crudapi.ModelClases;

import java.util.List;

public class DataTypesModel {
    String dataType,type,caption,placeholder,fontstyle;
    Integer fontsizr,max_len;
    Boolean deprecated, required;
    String color;
    List<DataControlModel> controlModelList;

    public List<DataControlModel> getControlModelList() {
        return controlModelList;
    }

    public void setControlModelList(List<DataControlModel> controlModelList) {
        this.controlModelList = controlModelList;
    }

    public DataTypesModel(List<DataControlModel> controlModelList) {
        this.controlModelList = controlModelList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DataTypesModel(String dataType, String type, String caption, String placeholder, String fontstyle, Integer fontsizr, Integer max_len, Boolean required, String color) {
        this.dataType = dataType;
        this.type = type;
        this.caption = caption;
        this.placeholder = placeholder;
        this.fontstyle = fontstyle;
        this.fontsizr = fontsizr;
        this.max_len = max_len;
        this.required = required;
        this.color = color;
    }

    public String getFontstyle() {
        return fontstyle;
    }

    public void setFontstyle(String fontstyle) {
        this.fontstyle = fontstyle;
    }

    public Integer getFontsizr() {
        return fontsizr;
    }

    public void setFontsizr(Integer fontsizr) {
        this.fontsizr = fontsizr;
    }

    public Integer getMax_len() {
        return max_len;
    }

    public void setMax_len(Integer max_len) {
        this.max_len = max_len;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public DataTypesModel(String dataType, String type, String caption, String placeholder) {
        this.dataType = dataType;
        this.type = type;
        this.caption = caption;
        this.placeholder = placeholder;
    }

    public DataTypesModel() {

    }

    public String getDataType() {
        return dataType;
    }

    public CharSequence setDataType(String dataType) {
        this.dataType = dataType;
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }
}
