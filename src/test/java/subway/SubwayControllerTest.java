package subway;

import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.SectionRepository;
import subway.domain.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SubwayControllerTest {
    @Test
    public void testSubwayController() {
        SubwayController subwayController = new SubwayController();
        subwayController.startService();
        Map<Line, List<Station>> map = SectionRepository.getLinesWithStations();
        for (Line line : map.keySet()) {
            System.out.println(line.getName());
            map.get(line).stream().map(Station::getName).forEach(System.out::println);
        }
    }

}