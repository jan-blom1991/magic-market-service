package com.jan.magicmarket.model;

import com.jan.magicmarket.config.constants.CardManaType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "card_mana_type_cost")
@AttributeOverride(name = "id", column = @Column(name = "card_mana_type_cost_id"))
public class CardManaTypeCost extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardManaType manaType;

    @Column(nullable = false)
    private Integer cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
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
