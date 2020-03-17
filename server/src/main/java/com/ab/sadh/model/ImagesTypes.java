package com.ab.sadh.model;

import lombok.Getter;

@Getter
public enum ImagesTypes {
    PANCHROMATIC("PANCHROMATIC"),
    MULTISPECTRAL("MULTISPECTRAL"),
    HYPERSPECTRAL("HYPERSPECTRAL");

    private String name;

    ImagesTypes(String name){
        this.name = name;
    }
}
