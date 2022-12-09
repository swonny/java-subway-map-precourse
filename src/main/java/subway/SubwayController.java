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
import java.util.LinkedHashMap;
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
        if (MainMenu.isFourthOption(selectedMenu)) {
            printTotalSubway();
        }
        if (MainMenu.willQuit(selectedMenu)) {
            OutputView.print("[INFO] 노선 조회를 종료합니다.");
        }
    }

    private void printTotalSubway() {
        StringBuilder result = new StringBuilder();
        LinkedHashMap<Line, List<Station>> sections = SectionRepository.sections();
        for (Line line : sections.keySet()) {
            result.append("[INFO] " + line.getName() + "\n");
            result.append("[INFO] ---\n");
            result.append(sections.get(line).stream()
                    .map(station -> "[INFO] " + station.getName())
                    .collect(Collectors.joining("\n"))
            );
            result.append("\n\n");
        }
        OutputView.print(result.toString());
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
            initializeSections(newLine, initializedValues.get(lineName));
        }
    }

    private void initializeStations(List<String> stations) {
        stations.stream()
                .filter(station -> !StationRepository.has(station))
                .map(StationMaker::make)
                .forEach(StationRepository::addStation);
    }

    private void initializeSections(Line line, List<String> stations) {
        SectionRepository.initializeSections(line, stations.stream()
                .map(StationController::getStation)
                .collect(Collectors.toList()));
    }
}
