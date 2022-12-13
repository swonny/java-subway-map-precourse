package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MainMenu {
    FIRST("1", "1. 역 관리"),
    SECOND("2", "2. 노선 관리"),
    THIRD("3", "3. 구간 관리"),
    FOURTH("4", "4. 지하철 노선도 출력"),
    QUIT("Q", "Q. 종료");

    private final String command;
    private final String menuName;

    MainMenu(String command, String menuName) {
        this.command = command;
        this.menuName = menuName;
    }

    public static String getWholeMenu() {
        return Arrays.stream(MainMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public static MainMenu getMenuByName(String input) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> menu.command.equals(input))
                .findAny()
                .orElseThrow(() ->new IllegalArgumentException("올바른 메뉴를 입력하세요"));
    }
}
