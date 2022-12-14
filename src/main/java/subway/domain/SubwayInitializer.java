package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubwayInitializer {

    public void init() {
        initializeStations();
        initializeLines();
        initializeSections();
    }

    private void initializeSections() {
        String lineOfSection1 = "2호선";
        List<Station> stationsOfSection1 = Arrays.asList("교대역", "강남역", "역삼역").stream()
                .map(station -> StationRepository.getStationByName(station)).collect(Collectors.toList());
        String lineOfSection2 = "3호선";
        List<Station> stationsOfSection2 = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역").stream()
                .map(station -> StationRepository.getStationByName(station)).collect(Collectors.toList());
        String lineOfSection3 = "신분당선";
        List<Station> stationsOfSection3 = Arrays.asList("강남역", "양재역", "양재시민의숲역").stream()
                .map(station -> StationRepository.getStationByName(station)).collect(Collectors.toList());

        LineRepository.getLineByName(lineOfSection1).initializeStations(stationsOfSection1);
        LineRepository.getLineByName(lineOfSection2).initializeStations(stationsOfSection2);
        LineRepository.getLineByName(lineOfSection3).initializeStations(stationsOfSection3);

    }

    private void initializeLines() {
        List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");
        lines.stream()
                .forEach(line -> LineRepository.addLine(new Line(line)));
    }

    private void initializeStations() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        stations.stream()
                .forEach(station -> StationRepository.addStation(new Station(station)));

    }


}
