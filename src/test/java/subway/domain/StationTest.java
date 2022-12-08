package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    @Test
    public void testStation() {
        Station station = new Station("송내역");
        assertThat(station.getName()).isEqualTo("송내역");
    }
}