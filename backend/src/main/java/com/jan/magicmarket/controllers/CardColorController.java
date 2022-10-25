package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.constants.CardColor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/card-colors")
public class CardColorController {

    @GetMapping()
    public String[] getCardColors() {
        return Arrays.stream(CardColor.values()).map(CardColor::getValue).toArray(String[]::new);
    }
}
