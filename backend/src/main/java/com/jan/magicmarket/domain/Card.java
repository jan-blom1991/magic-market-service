package com.jan.magicmarket.domain;

import com.jan.magicmarket.config.constants.CardColor;
import com.jan.magicmarket.config.constants.CardRarity;
import com.jan.magicmarket.config.constants.CardType;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    private Set<CardManaTypeCost> manaTypeCostList;

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public Integer getManaValue() {
        return manaValue;
    }

    public void setManaValue(Integer manaValue) {
        this.manaValue = manaValue;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public String getFlavourText() {
        return flavourText;
    }

    public void setFlavourText(String flavourText) {
        this.flavourText = flavourText;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getToughness() {
        return toughness;
    }

    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }

    public Set<CardManaTypeCost> getManaTypeCostList() {
        return manaTypeCostList;
    }

    public void setManaTypeCostList(Set<CardManaTypeCost> manaTypeCostList) {
        this.manaTypeCostList = manaTypeCostList;
    }
}
