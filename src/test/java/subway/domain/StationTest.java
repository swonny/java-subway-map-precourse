package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    @Test
    public void testStation() {
        Station station1 = new Station("h");
        Station station2 = new Station("h");
        assertThat(station1.equals(station2))
                .isTrue();
    }
}