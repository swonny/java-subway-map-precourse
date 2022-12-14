package subway.controller;

import constant.MainMenu;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class MainController {
    private StationController stationController;
    private LineController lineController;
    private SectionController sectionController;

    public MainController(Scanner scanner) {
        this.stationController = new StationController();
        this.lineController = new LineController();
        this.sectionController = new SectionController();
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
