package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {
    @Test
    public void testLineRepository() {
        Line line1 = new Line("2호선");
        Line line2 = new Line("2호선");
        LineRepository.addLine(line1);
        LineService lineService = new LineService();

        assertThatThrownBy(() -> lineService.addLine(line2, null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}