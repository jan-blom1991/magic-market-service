package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.constants.CardType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/card-types")
public class CardTypeController {

    @GetMapping()
    public String[] getCardTypes() {
        return Arrays.stream(CardType.values()).map(CardType::getValue).toArray(String[]::new);
    }
}
