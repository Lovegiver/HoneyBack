package enums;

import model.Unit;

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
