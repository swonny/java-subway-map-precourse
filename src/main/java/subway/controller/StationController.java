package subway.controller;

import constant.StationMenu;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.StationService;
import view.InputView;
import view.OutputView;

import java.util.List;

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
        if (StationMenu.BACK.equals(selection)) {
            return;
        }
        if (StationMenu.FIRST.equals(selection)) {
            addStation(InputView.readAddingStation());
        }
        if (StationMenu.SECOND.equals(selection)) {
            deleteStation(InputView.readDeletingStation());
        }
        if (StationMenu.THIRD.equals(selection)) {
            printStations();
        }
        run();
    }

    private void printStations() {
        try {
            List<Station> stations = StationRepository.stations();
            OutputView.printStations(stations);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void addStation(String addingStation) {
        try {
            stationService.addStation(addingStation);
            OutputView.printFinishedAddingStation();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void deleteStation(String deletingStation) {
        try {
            stationService.deleteStation(deletingStation);
            OutputView.printFinishedDeletingStation();
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
