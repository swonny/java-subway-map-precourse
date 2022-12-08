package subway;

import subway.defaults.Stations;
import subway.domain.*;
import subway.enums.LineManage;
import subway.enums.MainMenu;
import subway.enums.SectionManage;
import subway.enums.StationManage;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SubwayController {
    private final String BACK = "B";

    public void startService() {
        initializeSetting();
        selectMainMenu();
    }

    private void selectMainMenu() {
        String selectedMenu;
        do {
            OutputView.print(MainMenu.getWholeMenu());
            selectedMenu = InputView.readMainMenuSelection();
            runMainMenu(selectedMenu);
        } while (!MainMenu.willQuit(selectedMenu));

    }

    private void runMainMenu(String selectedMenu) {
        if (MainMenu.isFirstOption(selectedMenu)) {
            startManagingStation();
        }
        if (MainMenu.isSecondOption(selectedMenu)) {
            startManagingLine();
        }
        if (MainMenu.isThirdOption(selectedMenu)) {
            startManagingSection();
        }
        if (MainMenu.willQuit(selectedMenu)) {
            OutputView.print("[INFO] 노선 조회를 종료합니다.");
        }
    }

    private void startManagingSection() {
        OutputView.print(SectionManage.getWholeMenu());
        String selectedMenu = InputView.read();
        SectionController.runMenu(selectedMenu);
    }

    private void startManagingStation() {
        OutputView.print(StationManage.getWholeMenu());
        String selectedMenu = InputView.read();
        StationController.runMenu(selectedMenu);
    }

    private void startManagingLine() {
        OutputView.print(LineManage.getWholeMenu());
        String selectedMenu = InputView.read();
        LineController.runMenu(selectedMenu);
    }

    private void initializeSetting() {
        HashMap<String, List<String>> initializedValues = Stations.getStations();
        for (String lineName : initializedValues.keySet()) {
            Line newLine = LineController.makeLine(lineName);
            initializeStations(initializedValues.get(lineName));
            initializeLine(lineName);
            initializeSections(newLine, initializedValues.get(lineName));
        }
    }

    private void initializeSections(Line line, List<String> stations) {
        SectionRepository.initializeSections(line, stations.stream().map(StationMaker::make).collect(Collectors.toList()));
    }

    private void initializeLine(String name) {
        LineRepository.addLine(LineController.makeLine(name));
    }

    private void initializeStations(List<String> stations) {
        stations.stream()
                .filter(name -> !StationRepository.has(name))
                .forEach(station -> StationRepository.addStation(StationMaker.make(station)));
    }
}
