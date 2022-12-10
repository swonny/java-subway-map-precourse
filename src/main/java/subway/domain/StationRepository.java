package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (has(station.getName())) {
            throw new IllegalArgumentException("[ERROR] 중복되는 역 이름이 존재합니다.");
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        validateDeletion(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateDeletion(String stationName) {
        validateSectionInclusion(stationName);
        validateNotExist(stationName);
    }

    private static void validateNotExist(String stationName) {
        if (!StationRepository.has(stationName) || SectionRepository.has(StationRepository.get(stationName))) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    private static void validateSectionInclusion(String stationName) {
        if (SectionRepository.has(StationRepository.get(stationName))) {
            throw new IllegalArgumentException("[ERROR] 구간에 포함되는 역은 삭제할 수 없습니다.");
        }
    }

    public static Station get(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    public static boolean has(String name) {
        return stations().contains(get(name));
    }

}
