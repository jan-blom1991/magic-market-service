package com.jan.magicmarket.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileDetail {

    private final Long id;
    private final String fileName;
    private final String contentType;
    private final Long size;
    private final byte[] bytes;
    private final Integer order;
    private final Long fileGroupCode;
}
