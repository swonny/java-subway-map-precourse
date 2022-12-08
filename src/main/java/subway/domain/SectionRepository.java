package subway.domain;

import java.util.*;

public class SectionRepository {
    private static LinkedHashMap<Line, List<Station>> totalSubway = new LinkedHashMap<>();

    public static void addNewLine(Line newLine, Station upStation, Station downStation) {
        // TODO : 중복 없으면 유효성 검사 추가
        totalSubway.put(newLine, new ArrayList<>());
    }

    public static void initializeSections(Line line, List<Station> stations) {
        totalSubway.put(line, stations);
    }

    public static void addStationToSection(Line line, Station station, int order) {
        List<Station> stations = totalSubway.get(line);
        stations.add(order, station);
        totalSubway.put(line, stations);
    }

    public static void delete(Line line, Station station) {
        totalSubway.containsValue(station);
        List<Station> stations = totalSubway.get(line);
        if (stations.size() < 2) {
            throw new IllegalArgumentException();
        }
        stations.remove(stations.indexOf(station));
    }

    public static void deleteLineInSection(Line line) {
        totalSubway.remove(line);
    }

    public static Map<Line, List<Station>> getLinesWithStations() {
        return Collections.unmodifiableMap(totalSubway);
    }
}
