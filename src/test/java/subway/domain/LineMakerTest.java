package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineMakerTest {
    // TODO : 결과 확인을 위해 생성
    @Test
    public void testMakeLine() {
        assertThat(LineMaker.makeLine("1호선", "송내역", "구로역")
                .toString())
                .isEqualTo("1호선");
    }
}