package subway.domain;

import contants.ExceptionMessage;

import java.util.*;

public class SectionRepository {
    // TODO: List<Section> 시간 남으면 변경
    private static final HashMap<Line, List<Station>> sections = new HashMap<>();
    private static final int MINIMUM_SECTION_SIZE = 2;

    public static Map<Line, List<Station>> stations() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addNewSection(Line line, Station upStation, Station downStation) {
        if (!sections.containsKey(line)) {
            sections.put(line, new ArrayList<>());
        }
        sections.get(line).add(upStation);
        sections.get(line).add(downStation);
    }

    public static void addToSection(Line line, Station station, Integer order) {
        sections.get(line).add(order - 1, station);
    }

    public static boolean has(Line line) {
        return stations().containsKey(line);
    }

    public static boolean has(Station station) {
        return sections.containsValue(station);
//        for (Line line : sections.keySet()) {
//            if (sections.get(line).contains(station)) {
//                return true;
//            }
//        }
//        return false;
    }

    public static boolean isSectionDeletable(Line line) {
        return sections.get(line).size() <= MINIMUM_SECTION_SIZE;
    }

    public static Map<Line, List<Station>> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void deleteSection(Line line, Station station) {
        if (!sections.containsKey(line) || !sections.containsValue(station)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_DOES_NOT_EXIST_IN_SECTION.toString());
        }
        sections.remove(line, station);
    }

    public static void deleteLineInSection(Line line) {
        if (!sections.containsKey(line)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_DOES_NOT_EXIST.toString());
        }
        sections.remove(line);
    }

    public static void initSection(Line line, List<String> stations) {
        sections.put(line, new ArrayList<>());
        stations.stream()
                .map(StationRepository::get)
                .forEach(station -> sections.get(line).add(station));
    }
}
