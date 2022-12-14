package subway.domain;

import java.util.Objects;

public class Station {
    private static final int MINIMUM_LENGTH = 2;
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 두 글자 이상입니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }
}
