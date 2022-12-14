package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineServiceTest {
    @Test
    public void testLineService_중복_이름_테스트() {
        LineService lineService = new LineService();
        lineService.addLine(new Line("2호선"), "강남역", "강매역");
        assertThatThrownBy(() -> lineService.addLine(new Line("2호선"), "강남역", "강매역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testLineService_이름_두글자이하테스트() {
        LineService lineService = new LineService();
        assertThatThrownBy(() -> lineService.addLine(new Line("2"), "강남역", "강매역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testLineService_역이름두글자이하() {
        LineService lineService = new LineService();
        assertThatThrownBy(() -> lineService.addLine(new Line("2"), "강남역", "강"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testLineService_역이름두글자이하2() {
        LineService lineService = new LineService();
        assertThatThrownBy(() -> lineService.addLine(new Line("2"), "강", "강a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testLineService_역삭제오류() {
        LineService lineService = new LineService();
        assertThatThrownBy(() -> lineService.deleteLine("강a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삭제하려는 노선이 없습니다.");
    }
}