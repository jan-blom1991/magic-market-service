package com.jan.magicmarket.model;

import com.jan.magicmarket.config.constants.CardColor;
import com.jan.magicmarket.config.constants.CardRarity;
import com.jan.magicmarket.config.constants.CardType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "card")
@AttributeOverride(name = "id", column = @Column(name = "card_id"))
public class Card extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardColor color;

    @Column(nullable = false)
    private Integer manaValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType type;

    @Column
    private String subType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardRarity rarity;

    @Column(nullable = false)
    private String set;

    @Column
    private String oracleText;

    @Column
    private String flavourText;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private Integer power;

    @Column
    private Integer toughness;

    @OneToMany(mappedBy = "card")
    private Set<CardManaTypeCost> manaTypeCostList = new HashSet<>();
}
