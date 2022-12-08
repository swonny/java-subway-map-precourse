package subway.enums;

import subway.domain.Line;
import view.OutputView;

import java.util.List;

public enum LineManage {
    FIRST("1", "1. 노선 등록", List.of(
            "## 등록할 노선 이름을 입력하세요.",
            "## 등록할 노선의 상행 종점역 이름을 입력하세요.",
            "## 등록할 노선의 하행 종점역 이름을 입력하세요.")),
    SECOND("2", "2. 노선 삭제", List.of("## 삭제할 노선 이름을 입력하세요.")),
    THIRD("3", "3. 노선 조회", List.of("## 노선 목록")),
    BACK("B", "B. 돌아가기", List.of());

    private String userSelection;
    private List<String> followingMessage;
    private String printing;

    LineManage(String userSelection, String printing, List<String> followingMessage) {
        this.userSelection = userSelection;
        this.printing = printing;
        this.followingMessage = followingMessage;
    }

    public static String getWholeMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LineManage menu : LineManage.values()) {
            stringBuilder.append(menu.get() + "\n");
        }
        return stringBuilder.toString();
    }

    public String get() {
        return this.printing;
    }

    public List<String> getFollowingMessages() {
        return this.followingMessage;
    }

    public void printInfo(Line line) {
        OutputView.print("[INFO] " + line.getName());
    }
}
