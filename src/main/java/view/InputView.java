package view;

import java.util.Scanner;

public class InputView {

    public static String readMainMenuSelection() {
        return read();
    }

    public static String read() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
