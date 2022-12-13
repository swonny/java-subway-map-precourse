package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum LineMenu {
    FIRST("1", "1. 노선 등록"),
    SECOND("2", "2. 노선 삭제"),
    THIRD("3", "3. 노선 조회"),
    BACK("B", "B. 돌아가기");

    private final String command;
    private final String menuName;

    LineMenu(String command, String menuName) {
        this.command = command;
        this.menuName = menuName;
    }

    public static String getWholeMenu() {
        return Arrays.stream(LineMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public static LineMenu getMenuByName(String input) {
        return Arrays.stream(LineMenu.values())
                .filter(menu -> menu.command.equals(input))
                .findAny()
                .orElseThrow(() ->new IllegalArgumentException("올바른 메뉴를 입력하세요"));
    }
}
