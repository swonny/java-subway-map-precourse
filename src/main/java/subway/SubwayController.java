package subway;

import subway.defaults.Lines;
import subway.defaults.Stations;
import subway.domain.*;

import java.util.HashMap;
import java.util.List;

public class SubwayController {
    SectionRepository sectionRepository;
    StationRepository stationRepository;
    LineRepository lineRepository;

    public SubwayController() {
        sectionRepository = new SectionRepository();
        stationRepository = new StationRepository();
        lineRepository = new LineRepository();
    }

    public void startService() {
        initializeSetting();
    }

    private void initializeSetting() {
        HashMap<String, List<String>> initializedValues = Stations.getStations();
        for (String lineName : initializedValues.keySet()) {
            Line newLine = LineController.makeLine(lineName);
            initializeStations(initializedValues.get(lineName));
            initializeLine(lineName);
            initializeSections(newLine, initializedValues.get(lineName));
        }
    }

    private void initializeSections(Line line, List<String> stations) {
        stations.stream()
                .map(StationMaker::make)
                .forEach(station -> SectionRepository.addStationToSection(
                        line, station, SectionRepository.getLinesWithStations().size()));
    }

    private void initializeLine(String name) {
        LineRepository.addLine(LineController.makeLine(name));
    }

    private void initializeStations(List<String> stations) {
        stations.stream()
                .filter(name -> !StationRepository.has(name))
                .forEach(station -> StationRepository.addStation(StationMaker.make(station)));
    }
}
