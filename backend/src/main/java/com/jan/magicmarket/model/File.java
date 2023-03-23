package com.jan.magicmarket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "file")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "file_id"))
public class File extends BaseEntity {

    public static final Integer DEFAULT_ORDER = 1;

    @Column
    private String fileName;

    @Column
    private String contentType;

    @Column
    private Long size;

    @Lob
    @Column(length=200000)
    private byte[] bytes;

    @Column
    private Integer order;
}
