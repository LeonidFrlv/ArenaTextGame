package org.s1queence.game;

import org.s1queence.entity.*;
import org.s1queence.game.gameInterface.EnemySelector;
import org.s1queence.game.gameInterface.EntityTable;
import org.s1queence.game.gameInterface.HeroSelector;

import static org.s1queence.game.gameInterface.GameInterface.*;

public class Game {
    private Entity playerHero;
    private final int winsToEnd;

    public Game(int winsToEnd) {
        this.winsToEnd = winsToEnd;
        start();
        gameEnd();
    }

    public void setPlayerHero(Entity newHero) {
        playerHero = newHero;
    }

    private void showPlayerCharacter() {
        new EntityTable("ВЫ:", new Entity[]{playerHero});
    }

    private void start() {
        show("<<<<< Добро пожаловать на арену >>>>>");
        show("!! ДЛЯ ПОБЕДЫ СРАЗИТЕ " + winsToEnd +  " ПРОТИВНИКА(-ОВ) !!");
        leaveOrContinue("Готовы начать?");
        new HeroSelector(this);
        playerHero.setPlayer(true);

        for (int i = 0; i < winsToEnd; i++) {
            showPlayerCharacter();
            leaveOrContinue( i == 0 ? "Вы готовы к бою?" : "Вы готовы к следующему бою?");
            Entity selectedEnemy = new EnemySelector(playerHero, "Выберете противника:").getSelectedEnemy();
            new Fight(this, playerHero, selectedEnemy).startFight();

            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            show("Бой окончился вашей победой!");
            playerHero.heal();
            playerHero.levelUp();
        }
    }

    private void gameEnd() {
        show("<<< Вы победили! Игра окончена! >>>");
        quit();
    }

}
