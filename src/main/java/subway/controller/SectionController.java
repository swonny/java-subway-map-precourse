package subway.controller;

import constant.SectionMenu;
import subway.domain.*;
import view.InputView;
import view.OutputView;

public class SectionController {
    private LineService lineService;

    public SectionController() {
        this.lineService = new LineService();
    }

    public void run() {
        SectionMenu selection = getSectionMenu(InputView.readSectionMenu());
        select(selection);
    }

    private void select(SectionMenu selection) {
        // TODO : 예외 처리 해주기
        if (SectionMenu.BACK.equals(selection)) {
            return;
        }
        if (SectionMenu.FIRST.equals(selection)) {
            addSection();
        }
        if (SectionMenu.SECOND.equals(selection)) {
            deleteSection();
        }
    }

    private void deleteSection() {
        try {
            String deletingLine = InputView.readDeletingLineOfSection();
            String deletingStation = InputView.readDeletingStationOfSection();
            lineService.deleteSection(deletingLine, deletingStation);
            OutputView.printFinishedDeletingLine();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private void addSection() {
        try {
            String lineName = InputView.readLineName();
            String stationName = InputView.readStationName();
            int order = getOrder(InputView.getOrder());
            lineService.addSection(lineName, stationName, order);
            OutputView.printFinishedAddingSection();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    private int getOrder(String order) {
        if (order.matches("[0-9]+")) {
            return Integer.valueOf(order);
        }
        return getOrder(InputView.getOrder());
    }

    private Station getStation(String stationName) {
        try {
            return StationRepository.getStationByName(stationName);
        } catch (NullPointerException exception) {
            // TODO : StationMaker가 두 개 다 해도 좋을듯 : 레포 등록 & 생성 & 반환
            StationRepository.addStation(new Station(stationName));
            return StationRepository.getStationByName(stationName);
        }
    }

    private SectionMenu getSectionMenu(String input) {
        try {
            return SectionMenu.getMenuByName(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getSectionMenu(InputView.readStationMenu());
        }
    }
}
