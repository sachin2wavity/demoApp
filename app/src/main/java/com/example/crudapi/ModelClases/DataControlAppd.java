package com.example.crudapi.ModelClases;

import android.text.Layout;

import java.util.ArrayList;

public class DataControlAppd {
    public String id;
    public String caption;
    public String description;
    public int index;
    public String hint;
    public ArrayList<DataTypePojo> datatypes;
    public String title;
    public boolean required;
    public boolean deprecated;
    public boolean show_label;
    public boolean approverctrl;
    public boolean managerctrl;
    public String ctrltype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public ArrayList<DataTypePojo> getDatatypes() {
        return datatypes;
    }

    public void setDatatypes(ArrayList<DataTypePojo> datatypes) {
        this.datatypes = datatypes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }

    public boolean isShow_label() {
        return show_label;
    }

    public void setShow_label(boolean show_label) {
        this.show_label = show_label;
    }

    public boolean isApproverctrl() {
        return approverctrl;
    }

    public void setApproverctrl(boolean approverctrl) {
        this.approverctrl = approverctrl;
    }

    public boolean isManagerctrl() {
        return managerctrl;
    }

    public void setManagerctrl(boolean managerctrl) {
        this.managerctrl = managerctrl;
    }

    public String getCtrltype() {
        return ctrltype;
    }

    public void setCtrltype(String ctrltype) {
        this.ctrltype = ctrltype;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public boolean isImportdatactrl() {
        return importdatactrl;
    }

    public void setImportdatactrl(boolean importdatactrl) {
        this.importdatactrl = importdatactrl;
    }

    public boolean isModeratectrl() {
        return moderatectrl;
    }

    public void setModeratectrl(boolean moderatectrl) {
        this.moderatectrl = moderatectrl;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isOneTimeEntry() {
        return oneTimeEntry;
    }

    public void setOneTimeEntry(boolean oneTimeEntry) {
        this.oneTimeEntry = oneTimeEntry;
    }

    public boolean isGridview() {
        return gridview;
    }

    public void setGridview(boolean gridview) {
        this.gridview = gridview;
    }

    public boolean isEnable_search() {
        return enable_search;
    }

    public void setEnable_search(boolean enable_search) {
        this.enable_search = enable_search;
    }

    public boolean isHide_on_create() {
        return hide_on_create;
    }

    public void setHide_on_create(boolean hide_on_create) {
        this.hide_on_create = hide_on_create;
    }

    public boolean isRestrict_row_edit() {
        return restrict_row_edit;
    }

    public void setRestrict_row_edit(boolean restrict_row_edit) {
        this.restrict_row_edit = restrict_row_edit;
    }

    public boolean isRestrict_row_delete() {
        return restrict_row_delete;
    }

    public void setRestrict_row_delete(boolean restrict_row_delete) {
        this.restrict_row_delete = restrict_row_delete;
    }

    public String app_id;
    public Layout layout;
    public String form_id;
    public boolean importdatactrl;
    public boolean moderatectrl;
    public int fontSize;
    public boolean oneTimeEntry;
    public boolean gridview;
    public boolean enable_search;
    public boolean hide_on_create;
    public boolean restrict_row_edit;
    public boolean restrict_row_delete;


}
