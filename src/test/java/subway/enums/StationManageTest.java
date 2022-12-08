package subway.enums;

import org.junit.jupiter.api.Test;
import subway.domain.Station;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StationManageTest {
    @Test
    public void testStationManage() {
        assertThat(StationManage.getWholeMenu()).isEqualTo("a");
    }

    @Test
    public void testStationManageFunction() {
        StationManage.FIRST.printInfo();
        List.of("역삼역", "강남역", "역곡역").stream().forEach(StationManage.SECOND::printInfo);
    }

}