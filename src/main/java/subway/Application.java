package subway;

import subway.controller.MainController;
import subway.domain.SubwayInitializer;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainController mainController = new MainController(scanner, new SubwayInitializer());
        mainController.run();
    }
}
