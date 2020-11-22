package com.landl.hcare.entity;

public class Content {
    DataContent dataContent;
    MetadataContent metadataContent;

    public Content(DataContent dataContent, MetadataContent metadataContent) {
        this.dataContent = dataContent;
        this.metadataContent = metadataContent;
    }

    public Content() {
    }

    public DataContent getDataContent() {
        return dataContent;
    }

    public void setDataContent(DataContent dataContent) {
        this.dataContent = dataContent;
    }

    public MetadataContent getMetadataContent() {
        return metadataContent;
    }

    public void setMetadataContent(MetadataContent metadataContent) {
        this.metadataContent = metadataContent;
    }
}
