package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    public void testGenerate() {
        Line line = new Line("1호선");
        assertThat(line.getName()).isEqualTo("1호선");
    }
}