package subway.controllers;

import contants.StationMenu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SectionMenu {
    FIRST("1", "1. 구간 등록", List.of("## 원하는 기능을 선택하세요.", "## 역이름을 입력하세요.", "## 순서를 입력하세요.")),
    SECOND("2", "2. 구간 삭제", null),
    BACK("B", "B. 돌아가기", null);

    private final String userInput;
    private final String menuName;
    private final List<String> followingMessages;

    SectionMenu(String userInput, String menuName, List<String> followingMessages) {
        this.userInput = userInput;
        this.menuName = menuName;
        this.followingMessages = followingMessages;
    }

    public String getUserInput() {
        return this.userInput;
    }

    public static List<String> getFollowingMessages() {
        return FIRST.followingMessages;
    }

    public static String getWholeMenu() {
        return Arrays.stream(SectionMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }
}