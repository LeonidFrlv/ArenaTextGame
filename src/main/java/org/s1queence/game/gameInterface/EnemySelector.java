package org.s1queence.game.gameInterface;

import org.s1queence.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemySelector extends GameInterface{

    private final String title;
    private final Entity playerChar;
    private Entity selectedEnemy;
    public EnemySelector(Entity playerCharacter, String title) {
        this.playerChar = playerCharacter;
        this.title = title;
        generateContent();
    }

    private Entity[] generateEnemies() {
        int pLevel = playerChar.getLevel();
        Entity[] possibleEnemies = new Entity[] {
                new Warrior(pLevel),
                new Beast(pLevel),
                new Archer(pLevel),
                new Giant(pLevel),
                new Mage(pLevel),
                new Defender(pLevel),
                new Assasin(pLevel)
        };

        Random random = new Random();
        List<Entity> possibleEnemiesList = Arrays.asList(possibleEnemies);
        List<Entity> finalEnemies = new ArrayList<>();
        while (finalEnemies.size() < 3) {
            Entity randomEntity = possibleEnemiesList.get(random.nextInt(possibleEnemiesList.size()));
            if (!finalEnemies.contains(randomEntity)) finalEnemies.add(randomEntity);
        }

        return finalEnemies.toArray(new Entity[3]);
    }

    public Entity getSelectedEnemy() {
        return selectedEnemy;
    }

    @Override
    protected void generateContent() {
        Entity[] enemies = generateEnemies();
        new EntityTable(title, enemies);
        int enemyNum = readNum(1, enemies.length);
        Entity enemy = enemies[enemyNum - 1];
        selectedEnemy = enemy;
        new EntityTable("Ваш противник:", new Entity[]{enemy});
    }
}
