package org.s1queence.game;

import org.s1queence.entity.Entity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static org.s1queence.game.gameInterface.GameInterface.show;

public class Fight {
    private final Entity playerChar;
    private final Entity enemy;

    private final Game game;
    public Fight(Game game, Entity playerChar, Entity enemy) {
        this.playerChar = playerChar;
        this.enemy = enemy;
        this.game = game;
    }

    private int throwCoin() {
        return new Random().nextInt(2);
    }


    public void startFight() {
        show("<<< Бой начинается! >>>");
        new Timer().scheduleAtFixedRate(new TimerTask() {
            int whoHit = throwCoin();
            @Override
            public void run() {
                if (whoHit == 0) {
                    enemy.hit(playerChar);
                    whoHit = 1;
                } else {
                    playerChar.hit(enemy);
                    whoHit = 0;
                }

                if (enemy.isDead() || playerChar.isDead()) {
                    synchronized (game) {
                        game.notify();
                    }
                    cancel();
                }
            }
        },2000,2000);
    }

}
