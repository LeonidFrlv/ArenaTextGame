package org.s1queence.game.gameInterface;

import java.util.Scanner;

public abstract class GameInterface {
    protected String content;

    public static final Scanner reader = new Scanner(System.in);

    public static void show(String toShow) {
        System.out.println("-  " + toShow);
    }

    public static int readNum(int min, int max) {
        String s = reader.nextLine();
        int num;
        try {
            num = Integer.parseInt(s);
            if (num >= min && num <= max) return num;
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            show("Доступны только числа в диапазоне от " + min + " до " + max + ".");
            show("Повторите ввод:");
            return readNum(min, max);
        }
    }

    public static void leaveOrContinue(String title) {
        show(title);
        show("1. Да");
        show("2. Выход");
        int answer = readNum(1, 2);
        if (answer == 2) quit();
    }

    public static void quit() {
        System.exit(0);
    }

    protected abstract void generateContent();
}
