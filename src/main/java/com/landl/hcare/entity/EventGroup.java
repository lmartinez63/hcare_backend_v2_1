package com.landl.hcare.entity;

import java.util.List;

public class EventGroup {


    private Long id;
    private List<Event> events;
    private String groupClassName;
    private String color;
    private String textColor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupClassName() {
        return groupClassName;
    }

    public void setGroupClassName(String groupClassName) {
        this.groupClassName = groupClassName;
        switch(groupClassName){
            case "surgeryArea":
                setColor("blue");
                setTextColor("white");
                break;
            default:
                break;
        }

    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
}