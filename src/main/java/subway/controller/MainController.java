package subway.controller;

import constant.MainMenu;
import subway.domain.SubwayInformationService;
import subway.domain.SubwayInitializer;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class MainController {
    private StationController stationController;
    private LineController lineController;
    private SectionController sectionController;
    private SubwayInformationService subwayInformationService;

    public MainController(Scanner scanner, SubwayInitializer subwayInitializer) {
        this.stationController = new StationController();
        this.lineController = new LineController();
        this.sectionController = new SectionController();
        this.subwayInformationService = new SubwayInformationService();
        subwayInitializer.init();
    }

    public void run() {
        MainMenu selection = getMainMenuSelection(InputView.readMainMenu());
        select(selection);
    }

    private void select(MainMenu selection) {
        if (MainMenu.QUIT.equals(selection)) {
            return;
        }
        if (MainMenu.FIRST.equals(selection)) {
            stationController.run();
        }
        if (MainMenu.SECOND.equals(selection)) {
            lineController.run();
        }
        if (MainMenu.THIRD.equals(selection)) {
            sectionController.run();
        }
        if (MainMenu.FOURTH.equals(selection)) {
            subwayInformationService.run();
        }
        run();
    }

    private MainMenu getMainMenuSelection(String input) {
        try {
            return MainMenu.getMenuByName(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getMainMenuSelection(InputView.readMainMenu());
        }
    }
}
