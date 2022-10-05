package com.citizenweb.tooling.honeyback.core.domain.enums;

import com.citizenweb.tooling.honeyback.core.domain.model.Unit;

public enum WeightUnitType implements Unit {

    KG ("Kilogram(s)"),
    GR ("Grams"),
    MG ("Milligrams")
    ;

    private final String unit;

    WeightUnitType(String unit) {
        this.unit = unit;
    }

    @Override
    public String getUnit() {
        return this.unit;
    }

}
