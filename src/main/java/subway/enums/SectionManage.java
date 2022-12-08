package subway.enums;

import view.OutputView;

import java.util.Arrays;
import java.util.List;

public enum SectionManage {
    FIRST("1. 구간 등록", List.of("## 노선을 입력하세요.", "## 역이름을 입력하세요.", "## 순서를 입력하세요."), "1") {
        public void printInfo(String...value) {
            OutputView.print("[INFO] 구간이 등록되었습니다.");
        }
    },
    SECOND("2. 구간 삭제", List.of("## 삭제할 구간의 노선을 입력하세요.", "## 삭제할 구간의 역을 입력하세요."), "2") {
        public void printInfo(String...value) {
            OutputView.print("[INFO] 구간이 삭제되었습니다.");
        }
    },
    BACK("돌아가기", List.of(), "B") {
        public void printInfo(String...value) {
            OutputView.print("[INFO] 이전 메뉴로 돌아갑니다.");
        }
    };

    private String printing;
    private List<String> followingMessages;
    private String input;

    SectionManage(String printing, List<String> followingMessages, String input) {
        this.printing = printing;
        this.followingMessages = followingMessages;
        this.input = input;
    }

    public static String getWholeMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (SectionManage menu : SectionManage.values()) {
            stringBuilder.append(menu.get() + "\n");
        }
        return stringBuilder.toString();
    }

    private String get() {
        return this.printing;
    }

    abstract public void printInfo(String...value);

    public List<String> getFollowingMessages() {
        return this.followingMessages;
    }
}
