package com.jan.magicmarket.util;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class EnumUtil {

    public static <T extends Enum<T> & Labeled<K>, K> Map<Enum<T>, K> getEnumLabelMap(Class<T> type) {
        Map<Enum<T>, K> enumLabelMap = new LinkedHashMap<>();
        for (T t : type.getEnumConstants()) {
            enumLabelMap.put(t, t.getLabel());
        }
        return enumLabelMap;
    }
}
