package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum SectionMenu {
    FIRST("1", "1. 구간 등록"),
    SECOND("2", "2. 구간 삭제"),
    BACK("B", "B. 돌아가기");

    private final String command;
    private final String menuName;

    SectionMenu(String command, String menuName) {
        this.command = command;
        this.menuName = menuName;
    }

    public static String getWholeMenu() {
        return Arrays.stream(SectionMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public static SectionMenu getMenuByName(String input) {
        return Arrays.stream(SectionMenu.values())
                .filter(menu -> menu.command.equals(input))
                .findAny()
                .orElseThrow(() ->new IllegalArgumentException("올바른 메뉴를 입력하세요"));
    }
}
