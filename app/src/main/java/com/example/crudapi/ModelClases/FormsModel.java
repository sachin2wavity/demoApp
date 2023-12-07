package com.example.crudapi.ModelClases;


import android.text.Layout;

import java.util.ArrayList;

public class FormsModel {
    public String id;
    public int index;
    public int columns;
    public ArrayList<DataControlAppd> datacontrols;
    public Layout layout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public ArrayList<DataControlAppd> getDatacontrols() {
        return datacontrols;
    }

    public void setDatacontrols(ArrayList<DataControlAppd> datacontrols) {
        this.datacontrols = datacontrols;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
