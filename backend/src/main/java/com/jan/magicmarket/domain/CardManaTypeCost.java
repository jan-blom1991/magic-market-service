package com.jan.magicmarket.domain;

import com.jan.magicmarket.config.card.CardManaType;

import javax.persistence.*;

@Entity
public class CardManaTypeCost {

    @Id
    @Column(name = "card_mana_type_cost_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private CardManaType manaType;

    @Column(nullable = false)
    private Integer cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
