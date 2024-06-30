package org.s1queence.entity;

public class Warrior extends Entity{

    public Warrior(int level) {
        super(
                EntityType.WARRIOR,
                level,
                6,
                6,
                3,
                new String[] {
                        "Рассел",
                        "Ричард",
                        "Леонид"
                }
        );
    }
}
