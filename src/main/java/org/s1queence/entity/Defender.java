package org.s1queence.entity;

public class Defender extends Entity{
    public Defender(int level) {
        super(
                EntityType.DEFENDER,
                level,
                10,
                5,
                1,
                new String[] {
                        "Сильвер",
                        "Майнишел",
                        "Гай"
                }
        );
    }
}
