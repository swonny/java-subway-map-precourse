package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MINIMUM_SIZE = 2;
    private String name;
    private List<Station> stations;

    public Line(String name) {
        validate(name);
        this.name = name;
        this.stations = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

}
