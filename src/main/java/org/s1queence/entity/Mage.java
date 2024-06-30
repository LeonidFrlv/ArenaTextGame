package org.s1queence.entity;

public class Mage extends Entity{

    public Mage(int level) {
        super(
                EntityType.MAGE,
                level,
                4,
                4,
                7,
                new String[] {
                        "Милфхаус",
                        "Маллахиус",
                        "Танкадром"
                }
        );
    }
}
