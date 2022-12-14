package subway.controller;

import constant.LineMenu;
import constant.StationMenu;
import subway.domain.Line;
import subway.domain.LineService;
import subway.domain.Station;
import subway.domain.StationService;
import view.InputView;
import view.OutputView;


public class LineController {

    private LineService lineService;

    public LineController() {
        this.lineService = new LineService();
    }

    public void run() {
        LineMenu selection = getLineMenu(InputView.readLineMenu());
        select(selection);
    }

    private void select(LineMenu selection) {
        if (LineMenu.BACK.equals(selection)) {
            return;
        }
        if (LineMenu.FIRST.equals(selection)) {
            addLine();
        }
        if (LineMenu.SECOND.equals(selection)) {
            deleteLine(InputView.readDeletingLine());
        }
        if (LineMenu.THIRD.equals(selection)) {
            printLines();
        }
        run();
    }

    private void printLines() {
        try {
            OutputView.printLines(lineService.getLines());
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void deleteLine(String deletingLine) {
        try {
            lineService.deleteLine(deletingLine);
            OutputView.printFinishedDeletingLine();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void addLine() {
        try {
            // TODO : line도 String으로 넘겨줘야할듯
            Line line = new Line(InputView.readAddingLine());
            String startStation = InputView.readStartStation();
            String endStation = InputView.readEndStation();
            lineService.addLine(line, startStation, endStation);
            OutputView.printFinishedAddingLine();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private LineMenu getLineMenu(String input) {
        try {
            return LineMenu.getMenuByName(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getLineMenu(InputView.readStationMenu());
        }
    }

}
