package org.s1queence.entity;

public class Beast extends Entity {
    public Beast(int level) {
        super(
                EntityType.BEAST,
                level,
                3,
                7,
                5,
                new String[] {
                        "Гидра",
                        "Медведь",
                        "Попка"
                }
        );
    }

}
