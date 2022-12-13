package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

//    public InputView(Scanner scanner) {
//        this.scanner = scanner;
//    }

    public static String readMainMenu() {
        OutputView.printReadingMainMenu();
        return read();
    }

    private static String read() {
        return scanner.nextLine();
    }

    public static String readStationMenu() {
        OutputView.printReadingStationMenu();
        return read();
    }

    public static String readAddingStation() {
        OutputView.printAddingStation();
        return read();
    }

    public static String readDeletingStation() {
        OutputView.printDeletingStation();
        return read();
    }

    public static String readAddingLine() {
        OutputView.printAddingLine();
        return read();
    }

    public static String readStartStation() {
        OutputView.printAddingStartStation();
        return read();
    }

    public static String readEndStation() {
        OutputView.printAddingEndStation();
        return read();
    }

    public static String readDeletingLine() {
        OutputView.printDeletingLine();
        return read();
    }

    public static String readLineName() {
        OutputView.printReadingLineForSection();
        return read();
    }

    public static String readStationName() {
        OutputView.printReadingStationName();
        return read();
    }

    public static String getOrder() {
        OutputView.printGetOrderForSection();
        return read();
    }

    public static String readDeletingLineOfSection() {
        OutputView.printDeletingLineOfSection();
        return read();
    }

    public static String readDeletingStationOfSection() {
        OutputView.printDeletingStationOfSection();
        return read();
    }
}
