package com.jan.magicmarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProvisionalFile extends File {

    @Column
    private Long fileGroupCode;

    public Long getFileGroupCode() {
        return fileGroupCode;
    }

    public void setFileGroupCode(Long fileGroup) {
        this.fileGroupCode = fileGroup;
    }
}
