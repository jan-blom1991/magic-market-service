package com.jan.magicmarket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private Timestamp tsCreated;

    @Column
    private Timestamp tsChanged;

    @JoinColumn(name = "user_created_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userCreated;

    @JoinColumn(name = "user_changed_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userChanged;
}
