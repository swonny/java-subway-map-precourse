package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum StationMenu {
    FIRST("1", "1. 역 등록"),
    SECOND("2", "2. 역 삭제"),
    THIRD("3", "3. 역 조회"),
    BACK("B", "B. 돌아가기");

    private final String command;
    private final String menuName;

    StationMenu(String command, String menuName) {
        this.command = command;
        this.menuName = menuName;
    }

    public static String getWholeMenu() {
        return Arrays.stream(StationMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public static StationMenu getMenuByName(String input) {
        return Arrays.stream(StationMenu.values())
                .filter(menu -> menu.command.equals(input))
                .findAny()
                .orElseThrow(() ->new IllegalArgumentException("올바른 메뉴를 입력하세요"));
    }
}
