package view;

import subway.enums.MainMenu;

public class OutputView {

    public static void showMainMenu() {
        print(MainMenu.getWholeMenu());
    }

    public static void print(String value) {
        System.out.println(value);
    }
}
