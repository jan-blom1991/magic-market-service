package com.jan.magicmarket.domain;

import javax.persistence.*;

@Entity
public class Image extends BaseEntity {

    @Column
    private String fileName;

    @Column
    private String contentType;

    @Lob
    @Column(length=200000)
    private byte[] bytes;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
