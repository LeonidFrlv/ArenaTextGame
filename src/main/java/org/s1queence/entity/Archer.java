package org.s1queence.entity;

public class Archer extends Entity {
    public Archer(int level) {
        super(
                EntityType.ARCHER,
                level,
                2,
                6,
                7,
                new String[] {
                        "Льюс",
                        "Метью",
                        "Петью"
                }
        );
    }
}
