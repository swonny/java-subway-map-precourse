package subway.controllers;

import contants.ExceptionMessage;
import contants.LineMenu;
import subway.domain.*;
import view.InputView;
import view.OutputView;

import java.util.stream.Collectors;

public class LineController {
    private static final int FIRST_FOLLOWING_MESSAGE = 0;
    private static final int SECOND_FOLLOWING_MESSAGE = 1;
    private static final int THIRD_FOLLOWING_MESSAGE = 2;
    private static final int UP_STATION = SECOND_FOLLOWING_MESSAGE;
    private static final int DOWN_STATION = THIRD_FOLLOWING_MESSAGE;

    public static void run() {
        OutputView.printLineMenu(LineMenu.getWholeMenu());
        selectMenu();
    }

    private static void selectMenu() {
        OutputView.printSelectFunction();
        try {
            runMenu(InputView.selectFunction());
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            run();
        }
    }

    private static void runMenu(String selection) {
        if (LineMenu.FIRST.getUserInput().equals(selection)) {
            registerLine();
        }
        if (LineMenu.SECOND.getUserInput().equals(selection)) {
            deleteLine();
        }
        if (LineMenu.THIRD.getUserInput().equals(selection)) {
            printLines();
        }
        if (LineMenu.BACK.getUserInput().equals(selection)) {
            goBackToMain();
        }
    }

    private static void goBackToMain() {
        MainController.run();
    }

    private static void printLines() {
        OutputView.printLookupLines(LineRepository.lines().stream()
                .map(station -> station.getName()).collect(Collectors.toList())
        );
    }

    private static void deleteLine() {
        Line line = getLine();
        SectionRepository.deleteLineInSection(line);
        LineRepository.deleteLineByName(line.getName());
        OutputView.finishedDeletingLine();
    }

    private static Line getLine() {
        OutputView.printAskDeleteLineMessage();
        String deletingLineName = InputView.read();
        return LineRepository.get(deletingLineName);
    }

    private static void registerLine() {
        Line line = LineMaker.make(getAvailableLineName());
        Station upStation = getStationFromRepository(UP_STATION);
        Station downStation = getStationFromRepository(DOWN_STATION);
        LineRepository.addLine(line);
        addToSection(line, upStation, downStation);
        OutputView.printFinishedAddingLine();
    }

    private static Station getStationFromRepository(int messageIndex) {
        OutputView.print(LineMenu.getFollowingInputMessage().get(messageIndex));
        String stationName = InputView.read();
        if (!StationRepository.has(stationName)) {
            StationRepository.addStation(StationMaker.make(stationName));
        }
        return StationRepository.get(stationName);
    }

    private static String getAvailableLineName() {
        OutputView.print(LineMenu.getFollowingInputMessage().get(FIRST_FOLLOWING_MESSAGE));
        String lineName = InputView.read();
        validateLineDuplication(lineName);
        return lineName;
    }

    private static void validateLineDuplication(String lineName) {
        if (LineRepository.has(lineName)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_EXIST.toString());
        }
    }

    private static void addToSection(Line line, Station upStation, Station downStation) {
        SectionRepository.addNewSection(line, upStation, downStation);
    }
}
