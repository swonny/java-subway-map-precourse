package subway.controller;

import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class MainController {
    private static InputView inputView;
    private static OutputView outputView;

    public MainController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }
}
