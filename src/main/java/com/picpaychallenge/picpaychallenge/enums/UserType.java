package com.picpaychallenge.picpaychallenge.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
    COMMON(1, "Common"),
    MERCHANT(2, "Merchant");

    private final int id;
    private final String description;
}
