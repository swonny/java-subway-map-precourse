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

    @Test
    public void testLineService_섹션추가_중복오류() {
        LineService lineService = new LineService();
        lineService.addLine(new Line("2호선"), "강남역", "강매역");
        assertThatThrownBy(() -> lineService.addSection("2호선", "강남역", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 노선에 존재하는 역입니다.");
    }

    @Test
    public void testLineService_섹션추가_등록되지않은노선() {
        LineService lineService = new LineService();
        lineService.addLine(new Line("2호선"), "강남역", "강매역");
        assertThatThrownBy(() -> lineService.addSection("3호선", "강남역", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("등록된 노선이 없습니다.");
    }

    @Test
    public void testLineService_섹션추가_잘못된순서입력() {
        LineService lineService = new LineService();
        lineService.addLine(new Line("2호선"), "강남역", "강매역");
        assertThatThrownBy(() -> lineService.addSection("2호선", "역곡역", 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력할 수 있는 범위는 1 ~ 2까지입니다.");
    }

    @Test
    public void testLineService_섹션삭제_노선없을때() {
        LineService lineService = new LineService();
        lineService.addLine(new Line("2호선"), "강남역", "강매역");
        assertThatThrownBy(() -> lineService.deleteSection("3호선", "역곡역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("등록된 노선이 없습니다.");
    }

    @Test
    public void testLineService_섹션삭제_노선에역없을때() {
        LineService lineService = new LineService();
        lineService.addLine(new Line("2호선"), "강남역", "강매역");
        assertThatThrownBy(() -> lineService.deleteSection("2호선", "역곡역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("찾는 역이 없습니다.");
    }

    @Test
    public void testLineService_섹션삭제_노선에역이두개이하일때() {
        LineService lineService = new LineService();
        lineService.addLine(new Line("2호선"), "강남역", "강매역");
        assertThatThrownBy(() -> lineService.deleteSection("2호선", "강남역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한 노선에는 최소 두 개 이상의 역이 존재해야 합니다.");
    }
}