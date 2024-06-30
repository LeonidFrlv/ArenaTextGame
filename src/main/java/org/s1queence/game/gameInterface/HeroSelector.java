package org.s1queence.game.gameInterface;

import org.s1queence.entity.*;
import org.s1queence.game.Game;

public class HeroSelector extends GameInterface{

    private final Game game;
    public HeroSelector(Game game) {
        this.game = game;
        generateContent();
    }

    @Override
    protected void generateContent() {
        Entity[] starterHeroes = new Entity[] {
                new Warrior(1),
                new Beast(1),
                new Archer(1),
                new Giant(1),
                new Mage(1),
                new Defender(1),
                new Assasin(1)
        };

        new EntityTable("Выберете вашего бойца:", starterHeroes);
        show("Введите номер бойца:");
        int heroNum = readNum(1, starterHeroes.length);
        game.setPlayerHero(starterHeroes[heroNum - 1]);
    }
}
