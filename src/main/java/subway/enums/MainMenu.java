package subway.enums;

public enum MainMenu {
    FIRST("1. 역 관리", "1"),
    SECOND("2. 노선 관리", "2"),
    THIRD("3. 구간 관리", "3"),
    FOURTH("4. 지하철 노선도 출력", "4"),
    QUIT("Q. 종료", "5");

    private String menu;
    private String input;

    MainMenu(String printing, String input) {
        this.menu = printing;
        this.input = input;
    }

    public static boolean willQuit(String input) {
        return input.equals(QUIT.input);
    }

    public static boolean isFirstOption(String input) {
        return FIRST.input.equals(input);
    }

    public static boolean isSecondOption(String input) {
        return SECOND.input.equals(input);
    }

    public static boolean isThirdOption(String input) {
        return THIRD.input.equals(input);
    }

    public static boolean isFourthOption(String input) {
        return FOURTH.input.equals(input);
    }

    public String get() {
        return this.menu;
    }

    public static String getWholeMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MainMenu menu : MainMenu.values()) {
            stringBuilder.append(menu.get() + "\n");
        }
        return stringBuilder.toString();
    }

}
