package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.constants.CardColor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-colors")
public class CardColorController {

    @GetMapping()
    public CardColor[] getCardColors() {
        return CardColor.values();
    }
}
