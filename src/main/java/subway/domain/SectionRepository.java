package subway.domain;

import java.util.*;
import java.util.stream.Stream;

public class SectionRepository {
    private static LinkedHashMap<Line, List<Station>> totalSubway = new LinkedHashMap<>();

    public static void addNewLine(Line newLine, Station up, Station down) {
        // TODO : 중복 없으면 유효성 검사 추가
        totalSubway.put(newLine, List.of(up, down));
    }

    public static void addStationToSection(Line line, Station station, int order) {
        List<Station> stations = totalSubway.get(line);
        stations.add(order + 1, station);
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
