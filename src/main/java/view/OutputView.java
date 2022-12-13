package view;

import constant.MainMenu;
import constant.StationMenu;
import subway.domain.Line;
import subway.domain.Station;

import java.util.List;
import java.util.stream.Collectors;

import static constant.ViewMessage.*;

public class OutputView {
    public static void printReadingMainMenu() {
        print(MAIN_MENU_TITLE);
        print(MainMenu.getWholeMenu());
        printNewLine();
        print(SELECT_MENU);
    }

    private static void print(String value) {
        System.out.println(value);
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printExceptionMessage(Exception exception) {
        print("[ERROR] " + exception.getMessage());
    }

    public static void printReadingStationMenu() {
        printNewLine();
        print(STATION_MENU_TITLE);
        print(StationMenu.getWholeMenu());
        printNewLine();
        print(SELECT_MENU);
    }

    public static void printAddingStation() {
        printNewLine();
        print(READ_ADDING_STATION);
    }

    public static void printFinishedAddingStation() {
        printInfo(FINISHED_ADDING_STATION);
    }

    private static void printInfo(String value) {
        print("[INFO] " + value);
    }

    public static void printDeletingStation() {
        printNewLine();
        print(READ_DELETING_STATION);
    }

    public static void printFinishedDeletingStation() {
        printNewLine();
        printInfo(FINISHED_DELETING_STATION);
    }

    public static void printStations(List<Station> stations) {
        print(PRINTING_STATIONS_TITLE);
        stations.stream()
                .map(station -> station.getName())
                .forEach(stationName -> printInfo(stationName));
        printNewLine();
    }

    public static void printAddingLine() {
        printNewLine();
        print(READ_ADDING_LINE);
    }

    public static void printAddingStartStation() {
        printNewLine();
        print(READ_START_STATION);
    }

    public static void printAddingEndStation() {
        printNewLine();
        print(READ_END_STATION);
    }

    public static void printFinishedAddingLine() {
        printNewLine();
        printInfo(FINISHED_ADDING_LINE);
        printNewLine();
    }

    public static void printDeletingLine() {
        printNewLine();
        print(ASKING_DELETING_LINE_NAME);
    }

    public static void printFinishedDeletingLine() {
        printNewLine();
        printInfo(FINISHED_DELETING_LINE);
    }

    public static void printLines(List<Line> lines) {
        printNewLine();
        print(LINE_LIST);
        lines.stream().map(line -> line.getName())
                .forEach(line -> printInfo(line));
        printNewLine();
    }

    public static void printReadingLineForSection() {
        printNewLine();
        print(LINE_FOR_SECTION);
    }

    public static void printReadingStationName() {
        printNewLine();
        print(READ_STATION_NAME);
    }

    public static void printGetOrderForSection() {
        printNewLine();
        print(READ_ORDER);
    }

    public static void printFinishedAddingSection() {
        printNewLine();
        printInfo(FINISHED_ADDING_SECTION);
    }

    public static void printDeletingLineOfSection() {
        printNewLine();
        print(DELETING_LINE_OF_SECTION);
    }

    public static void printDeletingStationOfSection() {
        printNewLine();
        print(DELETING_STATION_OF_SECTION);
    }
}
