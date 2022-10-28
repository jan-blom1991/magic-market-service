package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.constants.CardType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-types")
public class CardTypeController {

    @GetMapping()
    public CardType[] getCardTypes() {
        return CardType.values();
    }
}
