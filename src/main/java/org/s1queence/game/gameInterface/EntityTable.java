package org.s1queence.game.gameInterface;

import org.s1queence.entity.Entity;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntityTable extends GameInterface {
    private final Entity[] entities;
    private final String title;

    public EntityTable(String title, Entity[] entities) {
        this.title = title;
        this.entities = entities;
        generateContent();
        show(content);
    }

    private int getLongestNameLength() {
        int length = 0;
        for (Entity en : entities) {
            int nameLength = en.getName().length();
            if (length < nameLength) length = nameLength;
        }

        return Math.max(length, 6);
    }

    private String getSpacesString(int length) {
        return " ".repeat(Math.max(0, length));
    }

    private final Map<String, String> tableColumns = new LinkedHashMap<>(){{
        put("name", "Имя");
        put("type", "Тип");
        put("level", "Уровень");
        put("maxHealth", "Здоровье");
        put("attackDamage", "Атака");
        put("armor", "Защита");
        put("agility", "Ловкость");
    }};

    @Override
    protected void generateContent() {
        StringBuilder content = new StringBuilder(title + "\n");
        int spacesLength = getLongestNameLength() * 2;

        StringBuilder tableColumnsTitle = new StringBuilder();

        for (String field : tableColumns.values()) {
            String spacesString = getSpacesString(spacesLength - field.length());
            tableColumnsTitle.append(field).append(spacesString);
        }

        int maxEntityIndex = (entities.length + 1 + ". ").length();
        content.append(getSpacesString(maxEntityIndex)).append(tableColumnsTitle).append("\n");

        for (Entity en : entities) {
            String entityNum = Arrays.asList(entities).indexOf(en) + 1 + ". ";
            content.append(entityNum);
            tableColumns.keySet().forEach(key -> {
                Map<String, String> info = en.getInfo();
                String value = info.get(key);
                content.append(info.get(key)).append(getSpacesString(spacesLength - value.length()));
            });
            content.append("\n");
        }

        if (entities.length > 1) content.append("=".repeat(tableColumnsTitle.length()));

        this.content = content.toString();
    }
}
