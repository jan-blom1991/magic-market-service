package com.jan.magicmarket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "provisional_file")
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
