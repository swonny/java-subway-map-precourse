package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {
    @Test
    public void testStationService() {
        StationService stationService = new StationService();
        stationService.addStation("ㅁ");
        assertThatThrownBy(() -> stationService.addStation("ㅁ"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}