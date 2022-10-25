package com.jan.magicmarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProvisionalFile extends File {

    @Column
    private Long fileGroup;

    public Long getFileGroup() {
        return fileGroup;
    }

    public void setFileGroup(Long fileGroup) {
        this.fileGroup = fileGroup;
    }
}
