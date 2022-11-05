package com.jan.magicmarket.util;

import com.jan.magicmarket.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ExceptionReference<T extends BaseEntity> {

    private final Class<T> type;

    @Setter
    private Long id;

    public ExceptionReference(Class<T> type) {
        this.type = type;
    }
}
