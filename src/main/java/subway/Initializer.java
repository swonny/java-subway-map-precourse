package subway;

import subway.defaults.Stations;
import subway.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Initializer {
    public void init() {
        HashMap<String, List<String>> initializedValues = Stations.getStations();
        for (String lineName : initializedValues.keySet()) {
            Line newLine = LineMaker.make(lineName);
            initializeStations(initializedValues.get(lineName));
            initializeSections(newLine, initializedValues.get(lineName));
        }
    }

    private void initializeStations(List<String> stations) {
        stations.stream()
                .filter(station -> !StationRepository.has(station))
                .map(StationMaker::make)
                .forEach(StationRepository::addStation);
    }

    private void initializeSections(Line line, List<String> stations) {
        SectionRepository.initializeSections(
                line,
                stations.stream()
                        .map(station -> {
                            if (StationRepository.has(station)) {
                                return StationRepository.get(station);
                            }
                            return StationMaker.make(station);
                        })
                        .collect(Collectors.toList())
        );
    }
}
