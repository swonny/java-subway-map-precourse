package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final int MINIMUM_STATIONS_PER_LINE = 2;

    private static LinkedHashMap<Line, List<Station>> totalSubway = new LinkedHashMap<>();

    public static LinkedHashMap<Line, List<Station>> sections() {
        return totalSubway;
    }

    public static void addNewLine(Line newLine, Station upStation, Station downStation) {
        // TODO : 중복 없으면 유효성 검사 추가
        if (!StationRepository.has(upStation.getName())) {
            StationRepository.addStation(upStation);
        }
        if (!StationRepository.has(downStation.getName())) {
            StationRepository.addStation(downStation);
        }
        totalSubway.put(newLine, List.of(upStation, downStation));
    }

    public static void initializeSections(Line line, List<Station> stations) {
        totalSubway.put(line, stations);
    }

    public static void addStationToSection(Line line, Station station, int order) {
        List<Station> stations = totalSubway.get(line);
        stations.add(order - 1, station);
        totalSubway.put(line, stations);
    }

    public static void deleteSection(Line line, Station station) {
        if (hasLessThanTwoStations(line)) {
            throw new IllegalArgumentException("[ERROR] 해당 노선에 역이 두 개 이하이기 때문에 삭제할 수 없습니다.");
        }
        List<Station> stations = totalSubway.get(line);
        stations.remove(stations.indexOf(station));
    }

    public static void deleteLineInSection(Line line) {
        totalSubway.remove(line);
    }

    public static Map<Line, List<Station>> getLinesWithStations() {
        return Collections.unmodifiableMap(totalSubway);
    }

    public static boolean has(Station station) {
        for (Line line : totalSubway.keySet()) {
            if (totalSubway.get(line).contains(station)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLessThanTwoStations(Line line) {
        System.out.println(totalSubway.get(line).size());
        return totalSubway.get(line).size() <= MINIMUM_STATIONS_PER_LINE;
    }
}
