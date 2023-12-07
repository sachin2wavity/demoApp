package com.example.crudapi.ModelClases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValuePojo {
    private long index;
    private String name;
    private String value;
    private String bgcolor;

    @JsonProperty("index")
    public long getIndex() { return index; }
    @JsonProperty("index")
    public void setIndex(long value) { this.index = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }

    @JsonProperty("bgcolor")
    public String getBgcolor() { return bgcolor; }
    @JsonProperty("bgcolor")
    public void setBgcolor(String value) { this.bgcolor = value; }
}
