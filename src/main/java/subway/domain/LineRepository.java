package subway.domain;

import java.util.*;

public class LineRepository {
    /*
    * Line의 상태를 저장
    * 추가로 생성되는 객체에 대해서 XXXRepository 네이밍으로 저장 클래스를 추가할 수 있다. ??? 저장클래스?
    * 객체들의 상태를 관리하기 위해서 XXXRepository 클래스를 활용해 저장 로직을 구현해야 한다. ??? 저장 로직?
    * 필요에 따라 자유롭게 수정이 가능하다.
    * */
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (has(line)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
        lines.add(line);
    }

    private static boolean has(Line line) {
        try {
            get(line.getName());
        } catch (IllegalArgumentException exception) {
            return false;
        }
        return true;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line get(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
    }
}
