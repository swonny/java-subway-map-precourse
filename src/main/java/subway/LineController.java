package subway;

import subway.domain.*;
import subway.enums.LineManage;
import subway.enums.StationManage;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LineController {
    public static void deleteLine(String name) {
        SectionRepository.deleteLineInSection(LineRepository.get(name));
        LineRepository.deleteLineByName(name);
    }

    public static void runMenu(String selectedMenu) {
        if (LineManage.FIRST.get().equals(selectedMenu)) {
            addLine();
        }
        if (LineManage.SECOND.get().equals(selectedMenu)) {
            deleteLine();
        }
        if (LineManage.THIRD.get().equals(selectedMenu)) {
            printLines();
        }
        if (StationManage.BACK.get().equals(selectedMenu)) {
            OutputView.print("[INFO] 메인 메뉴로 돌아갑니다.");
        }
    }

    private static void printLines() {
        List<String> followingMessages = LineManage.THIRD.getFollowingMessages();
        LineRepository.lines().stream()
                .forEach(LineManage.SECOND::printInfo);
    }


    private static void deleteLine() {
        List<String> followingMessages = LineManage.SECOND.getFollowingMessages();
        OutputView.print(followingMessages.get(0));
        deleteLine(InputView.read());
    }

    private static void addLine() {
        List<String> followingMessages = LineManage.FIRST.getFollowingMessages();
        OutputView.print(followingMessages.get(0));
        String newLine = InputView.read();
        OutputView.print(followingMessages.get(1));
        String up = InputView.read();
        OutputView.print(followingMessages.get(2));
        String down = InputView.read();
        makeLine(newLine, StationMaker.make(up), StationMaker.make(down));
    }

    public static Line makeLine(String name, Station upStation, Station downStation) {
        Line line = new Line(name);
        StationRepository.addStation(upStation);
        StationRepository.addStation(downStation);
        LineRepository.addLine(line);
        SectionRepository.addNewLine(line, upStation, downStation);
        return line;
    }
}