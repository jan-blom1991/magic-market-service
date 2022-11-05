package com.jan.magicmarket.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public abstract class PageRequestUtil {

    public static final int DEFAULT_PAGE_SIZE = 20;

    public static PageRequest createRequest(@NonNull String sort,
                                            @Nullable String order,
                                            @Nullable Integer page,
                                            @Nullable Integer size) {

        Sort.Direction direction = StringUtils.isNotEmpty(order) ? Sort.Direction.fromString(order) : Sort.Direction.ASC;

        return PageRequest.of(
                page != null ? page : 0,
                size != null ? size : DEFAULT_PAGE_SIZE,
                Sort.by(direction, sort));
    }
}
