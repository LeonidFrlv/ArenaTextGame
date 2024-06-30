package org.s1queence.entity;

public class Assasin extends Entity{

    public Assasin(int level) {
        super(
                EntityType.ASSASIN,
                level,
                1,
                5,
                10,
                new String[] {
                        "Фил",
                        "Кай",
                        "Биллимор"
                }
        );
    }
}
