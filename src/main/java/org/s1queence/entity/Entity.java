package org.s1queence.entity;

import java.util.*;

import static org.s1queence.game.gameInterface.GameInterface.quit;
import static org.s1queence.game.gameInterface.GameInterface.show;

public abstract class Entity {
    protected final String name;
    protected final EntityType type;
    protected int health;
    protected int maxHealth;
    protected int attackDamage;
    protected int armor;
    protected int agility;
    protected int level;
    protected String[] typeNames;
    protected boolean isPlayer = false;
    protected Entity killer;
    protected boolean isDead;
    protected Map<String, String> info;

    public Entity(EntityType type, int level, int armor, int attackDamage, int agility, String[] typeNames) {
        this.type = type;
        this.typeNames = typeNames;
        this.armor = armor + level;
        this.attackDamage = attackDamage + level;
        this.agility = agility + level;
        this.level = level;

        health = maxHealth = Math.max(10, armor * 2 + level) ;
        this.name = generateName();

        updateInfo();
    }

    private void updateInfo() {
        this.armor = armor + level;
        this.attackDamage = attackDamage + level;
        this.agility = agility + level;
        maxHealth = Math.max(10, armor * 2 + level) ;

        info = new LinkedHashMap<>(){{
            put("name", name);
            put("type", type.toString());
            put("level", "" + level);
            put("maxHealth", "" + maxHealth);
            put("attackDamage", "" + attackDamage);
            put("armor", "" + armor);
            put("agility", "" + agility);
        }};
    }

    public String generateName() {
        List<String> namesList = Arrays.asList(typeNames);
        Random rand = new Random();
        return namesList.get(rand.nextInt(namesList.size()));
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void levelUp() {
        level++;
        updateInfo();
    }

    public void hit(Entity target) {
        String targetName = target.getName();
        if (target.isAttackDodged()) {
            show(target.getName() + " ловко уворачивается от атаки " + name + "!");
            return;
        }

        int targetArmor = target.getArmor();
        int damage = Math.max(attackDamage - targetArmor, 2);
        target.setHealth(target.getHealth() - damage);
        show(name + " наносит " + targetName + " " + damage + " ед. урона, оставляя " + target.getHealth() + " оз!");

        if (target.getHealth() == 0) {
            target.setKiller(this);
            target.die();
        }
    }

    public void die() {
        isDead = true;
        show(killer.getName() + " жестоко убивает " + getName() + "!");
        if (isPlayer) {
            show("Игра окончена! Вы проиграли!");
            quit();
        }
    }

    public boolean isAttackDodged() {
        double dodgeChance = Math.min(80.0, 25.0d + agility * 1.7);

        return (1 + Math.random() * 100) <= dodgeChance;
    }

    public void setKiller(Entity killer) {
        this.killer = killer;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setHealth(int newHealth) {
        health = Math.max(0, newHealth);
    }

    public void setPlayer(boolean newState) {
        isPlayer = newState;
    }

    public void heal() {
        health = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

}
