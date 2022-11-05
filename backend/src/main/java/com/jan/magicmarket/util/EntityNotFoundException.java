package com.jan.magicmarket.util;

import com.jan.magicmarket.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EntityNotFoundException extends Exception {

    ExceptionReference<? extends BaseEntity> reference;
}
