package com.example.crudapi.ModelClases;

import java.util.ArrayList;

public class AppDefination {
    public String id;
    public String caption;
    public String description;
    public long created_time;
    public long modified_time;
    public String created_by;
    public String modified_by;
    public Long version_number;
    public long version_stamp;
    public String status;
    public boolean catalogue;
    public ArrayList<Object> tags;
    public String prefix;
    public String feature;
    public boolean system;
    public boolean hideWebnotifications;
    public boolean recdEditDisabled;
    public String application_type;
    public ArrayList<FormsModel> forms;
    public String activity_id;
    public int download_count;
    public int rating_count;
    public int avg_rating;
    public ArrayList<Object> references;
    public ArrayList<Object> multiLock_statuses;
    public boolean restrict_manualentry;
    public String create_action;
    public String update_action;
    public String record_identifier;
    public boolean approver_can_edit;
    public boolean draft;
    public String record_view;
    public boolean geofence_enabled;
    public boolean owner_view;
    public boolean is_record_edit_disabled;
    public boolean hide_ui_recordstate;
    public boolean disable_notifications;
    public String title_dc;
    public boolean hide_web_notifications;

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

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public long getModified_time() {
        return modified_time;
    }

    public void setModified_time(long modified_time) {
        this.modified_time = modified_time;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public Long getVersion_number() {
        return version_number;
    }

    public void setVersion_number(Long version_number) {
        this.version_number = version_number;
    }

    public long getVersion_stamp() {
        return version_stamp;
    }

    public void setVersion_stamp(long version_stamp) {
        this.version_stamp = version_stamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCatalogue() {
        return catalogue;
    }

    public void setCatalogue(boolean catalogue) {
        this.catalogue = catalogue;
    }

    public ArrayList<Object> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public boolean isHideWebnotifications() {
        return hideWebnotifications;
    }

    public void setHideWebnotifications(boolean hideWebnotifications) {
        this.hideWebnotifications = hideWebnotifications;
    }

    public boolean isRecdEditDisabled() {
        return recdEditDisabled;
    }

    public void setRecdEditDisabled(boolean recdEditDisabled) {
        this.recdEditDisabled = recdEditDisabled;
    }

    public String getApplication_type() {
        return application_type;
    }

    public void setApplication_type(String application_type) {
        this.application_type = application_type;
    }

    public ArrayList<FormsModel> getForms() {
        return forms;
    }

    public void setForms(ArrayList<FormsModel> forms) {
        this.forms = forms;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public int getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(int avg_rating) {
        this.avg_rating = avg_rating;
    }

    public ArrayList<Object> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<Object> references) {
        this.references = references;
    }

    public ArrayList<Object> getMultiLock_statuses() {
        return multiLock_statuses;
    }

    public void setMultiLock_statuses(ArrayList<Object> multiLock_statuses) {
        this.multiLock_statuses = multiLock_statuses;
    }

    public boolean isRestrict_manualentry() {
        return restrict_manualentry;
    }

    public void setRestrict_manualentry(boolean restrict_manualentry) {
        this.restrict_manualentry = restrict_manualentry;
    }

    public String getCreate_action() {
        return create_action;
    }

    public void setCreate_action(String create_action) {
        this.create_action = create_action;
    }

    public String getUpdate_action() {
        return update_action;
    }

    public void setUpdate_action(String update_action) {
        this.update_action = update_action;
    }

    public String getRecord_identifier() {
        return record_identifier;
    }

    public void setRecord_identifier(String record_identifier) {
        this.record_identifier = record_identifier;
    }

    public boolean isApprover_can_edit() {
        return approver_can_edit;
    }

    public void setApprover_can_edit(boolean approver_can_edit) {
        this.approver_can_edit = approver_can_edit;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public String getRecord_view() {
        return record_view;
    }

    public void setRecord_view(String record_view) {
        this.record_view = record_view;
    }

    public boolean isGeofence_enabled() {
        return geofence_enabled;
    }

    public void setGeofence_enabled(boolean geofence_enabled) {
        this.geofence_enabled = geofence_enabled;
    }

    public boolean isOwner_view() {
        return owner_view;
    }

    public void setOwner_view(boolean owner_view) {
        this.owner_view = owner_view;
    }

    public boolean isIs_record_edit_disabled() {
        return is_record_edit_disabled;
    }

    public void setIs_record_edit_disabled(boolean is_record_edit_disabled) {
        this.is_record_edit_disabled = is_record_edit_disabled;
    }

    public boolean isHide_ui_recordstate() {
        return hide_ui_recordstate;
    }

    public void setHide_ui_recordstate(boolean hide_ui_recordstate) {
        this.hide_ui_recordstate = hide_ui_recordstate;
    }

    public boolean isDisable_notifications() {
        return disable_notifications;
    }

    public void setDisable_notifications(boolean disable_notifications) {
        this.disable_notifications = disable_notifications;
    }

    public String getTitle_dc() {
        return title_dc;
    }

    public void setTitle_dc(String title_dc) {
        this.title_dc = title_dc;
    }

    public boolean isHide_web_notifications() {
        return hide_web_notifications;
    }

    public void setHide_web_notifications(boolean hide_web_notifications) {
        this.hide_web_notifications = hide_web_notifications;
    }

    public boolean isHide_activities() {
        return hide_activities;
    }

    public void setHide_activities(boolean hide_activities) {
        this.hide_activities = hide_activities;
    }

    public boolean isText_analysis() {
        return text_analysis;
    }

    public void setText_analysis(boolean text_analysis) {
        this.text_analysis = text_analysis;
    }

    public boolean hide_activities;
    public boolean text_analysis;
}
