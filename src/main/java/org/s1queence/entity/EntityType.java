package org.s1queence.entity;

public enum EntityType {
    WARRIOR ("Воин"),
    BEAST ("Зверь"),
    ARCHER ("Лучник"),
    GIANT ("Гигант"),
    MAGE ("Маг"),
    DEFENDER ("Защитник"),
    ASSASIN ("Ассасин");
    private final String name;

    EntityType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
