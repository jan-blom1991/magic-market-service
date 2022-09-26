package com.jan.magicmarket.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private Timestamp tsCreated;

    @Column
    private Timestamp tsChanged;


    @ManyToOne(fetch = FetchType.LAZY)
    private User userCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userChanged;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTsCreated() {
        return tsCreated;
    }

    public void setTsCreated(Timestamp tsCreated) {
        this.tsCreated = tsCreated;
    }

    public Timestamp getTsChanged() {
        return tsChanged;
    }

    public void setTsChanged(Timestamp tsChanged) {
        this.tsChanged = tsChanged;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public User getUserChanged() {
        return userChanged;
    }

    public void setUserChanged(User userChanged) {
        this.userChanged = userChanged;
    }
}
