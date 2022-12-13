package subway.controller;

import constant.StationMenu;
import subway.domain.StationService;
import view.InputView;
import view.OutputView;

public class StationController {
    StationService stationService;

    public StationController() {
        this.stationService = new StationService();
    }

    public void run() {
        StationMenu selection = getStationMenu(InputView.readStationMenu());
        select(selection);
    }

    private void select(StationMenu selection) {
        // TODO : 예외 처리 해주기
        if (StationMenu.BACK.equals(selection)) {
            return;
        }
        if (StationMenu.FIRST.equals(selection)) {
            addStation(InputView.readAddingStation());
            OutputView.printFinishedAddingStation();
        }
        if (StationMenu.SECOND.equals(selection)) {
            deleteStation(InputView.readDeletingStation());
            OutputView.printFinishedDeletingStation();
        }
        if (StationMenu.THIRD.equals(selection)) {
            printLines();
        }
    }

    private void printLines() {
        try {
            OutputView.printStations(stationService.getStations());
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void addStation(String addingStation) {
        try {
            stationService.addStation(addingStation);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void deleteStation(String deletingStation) {
        try {
            stationService.deleteStation(deletingStation);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private StationMenu getStationMenu(String input) {
        try {
            return StationMenu.getMenuByName(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getStationMenu(InputView.readStationMenu());
        }
    }
}
