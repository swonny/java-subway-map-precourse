package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MINIMUM_SIZE = 2;
    private static final int MINIMUM_NUMBER_OF_STATIONS = 2;
    private String name;
    private List<Station> stations;

    public Line(String name) {
        validate(name);
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public void add(Station station, int orderIndex) {
        if (stations.size() - 1 < orderIndex) {
            throw new IllegalArgumentException("입력할 수 있는 범위는 1 ~ " + stations.size() + "까지입니다.");
        }
        stations.add(station);
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_SIZE) {
            throw new IllegalArgumentException("노선 이름은 두 글자 이상입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void addNewStation(Station startStation, Station endStation) {
        this.stations.add(startStation);
        this.stations.add(endStation);
    }

    public boolean has(Station station) {
        return this.stations.contains(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    public void deleteStation(Station station) {
        if (stations.contains(station)) {
            stations.remove(station);
        }
        throw new IllegalArgumentException("구간에 존재하지 않는 역입니다.");
    }

    public boolean isDeletable() {
        return stations.size() > MINIMUM_NUMBER_OF_STATIONS;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
