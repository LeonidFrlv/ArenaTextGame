package org.s1queence.entity;

public class Giant extends Entity{
    public Giant(int level) {
        super(
                EntityType.GIANT,
                level,
                4,
                11,
                1,
                new String[] {
                        "Руфус",
                        "Дам",
                        "Вуд"
                }
        );
    }
}
