package subway.enums;

import subway.domain.Station;
import subway.domain.StationMaker;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum StationManage {
    FIRST("1. 역 등록", List.of("## 등록할 역 이름을 입력하세요."), "1") {
        public void printInfo(String...value) {
            OutputView.print("[INFO] 지하철 역이 등록되었습니다.");
        }
    },
    SECOND("2. 역 삭제", List.of("## 역 목록"), "2") {
        public void printInfo(String...value) {
            Arrays.stream(value).forEach(station -> OutputView.print("[INFO] ".concat(value[0])));
        }
    },
    THIRD("3. 역 조회", List.of("## 삭제할 역 이름을 입력하세요."), "3") {
        public void printInfo(String...value) {
            OutputView.print("[INFO] 지하철 역이 삭제되었습니다.");
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
    abstract public void printInfo(String...value);

    StationManage(String printing, List<String> followingMessages, String input) {
        this.printing = printing;
        this.followingMessages = followingMessages;
        this.input = input;
    }

    public static String getWholeMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StationManage menu : StationManage.values()) {
            stringBuilder.append(menu.get() + "\n");
        }
        return stringBuilder.toString();
    }

    public String get() {
        return this.printing;
    }

    public List<String> getFollowingMessages() {
        return this.followingMessages;
    }

    public void printInfo(Station station) {
    }
}
