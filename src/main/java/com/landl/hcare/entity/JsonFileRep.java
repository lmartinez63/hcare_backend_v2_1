package com.landl.hcare.entity;

import java.util.List;

public class JsonFileRep {

    private String name;

    private String fileType;

    List<JsonFileRep> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<JsonFileRep> getChildren() {
        return children;
    }

    public void setChildren(List<JsonFileRep> children) {
        this.children = children;
    }
}
