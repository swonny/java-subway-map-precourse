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
        LineMenu selection = getLineMenu(InputView.readStationMenu());
        select(selection);
    }

    private void select(LineMenu selection) {
        // TODO : 예외 처리 해주기
        if (LineMenu.BACK.equals(selection)) {
            return;
        }
        if (LineMenu.FIRST.equals(selection)) {
            addLine();
            OutputView.printFinishedAddingLine();
        }
        if (LineMenu.SECOND.equals(selection)) {
            deleteLine(InputView.readDeletingLine());
            OutputView.printFinishedDeletingLine();
        }
        if (LineMenu.THIRD.equals(selection)) {
            printLines();
        }
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
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void addLine() {
        try {
            Line line = new Line(InputView.readAddingLine());
            Station startStation = new Station(InputView.readStartStation());
            Station endStation = new Station(InputView.readEndStation());
            lineService.addLine(line, startStation, endStation);
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
