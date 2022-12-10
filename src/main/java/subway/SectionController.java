package subway;

import subway.domain.*;
import subway.enums.LineManage;
import subway.enums.SectionManage;
import subway.enums.StationManage;
import view.InputView;
import view.OutputView;

import java.util.List;

public class SectionController {

    public static void runMenu(String selectedMenu) {
        if (LineManage.FIRST.get().equals(selectedMenu)) {
            runFirstMenu();
        }
        if (LineManage.SECOND.get().equals(selectedMenu)) {
            runSecondMenu();
        }
        if (StationManage.BACK.get().equals(selectedMenu)) {
            OutputView.print("[INFO] 메인 메뉴로 돌아갑니다.");
        }
    }

    private static void runSecondMenu() {
        List<String> followingMessages = SectionManage.SECOND.getFollowingMessages();
        OutputView.print(followingMessages.get(0));
        String lineName = InputView.read();
        OutputView.print(followingMessages.get(0));
        String stationName = InputView.read();
        deleteStationInSection(lineName, stationName);
    }

    private static void runFirstMenu() {
        List<String> followingMessages = SectionManage.FIRST.getFollowingMessages();
        OutputView.print(followingMessages.get(0));
        String newLine = InputView.read();
        OutputView.print(followingMessages.get(1));
        String station = InputView.read();
        OutputView.print(followingMessages.get(2));
        String order = InputView.read();
        addSection(newLine, station, Integer.valueOf(order));
    }

    public static void addSection(String lineName, String stationName, int stationOrder) {
        if (!StationRepository.has(stationName)) {
            Station station = StationMaker.make(stationName);
            StationRepository.addStation(station);
        }
        SectionRepository.addStationToSection(
                LineRepository.get(lineName),
                StationRepository.get(stationName),
                stationOrder
        );
    }

    public static void deleteStationInSection(String lineName, String stationName) {
        SectionRepository.deleteSection(LineRepository.get(lineName), StationRepository.get(stationName));
    }
}
