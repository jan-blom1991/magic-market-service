package com.jan.magicmarket.domain;

import com.jan.magicmarket.config.constants.CardManaType;

import javax.persistence.*;

@Entity
public class CardManaTypeCost extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardManaType manaType;

    @Column(nullable = false)
    private Integer cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Card card;

    public CardManaType getManaType() {
        return manaType;
    }

    public void setManaType(CardManaType manaType) {
        this.manaType = manaType;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
