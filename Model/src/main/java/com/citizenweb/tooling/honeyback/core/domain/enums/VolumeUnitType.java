package com.citizenweb.tooling.honeyback.core.domain.enums;

import com.citizenweb.tooling.honeyback.core.domain.model.Unit;

public enum VolumeUnitType implements Unit {

    L ("Litre(s)"),
    CL ("Centiliters"),
    ML ("Milliliters")
    ;

    private final String unit;

    VolumeUnitType(String unit) {
        this.unit = unit;
    }

    @Override
    public String getUnit() {
        return this.unit;
    }

}
