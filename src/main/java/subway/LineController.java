package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LineController {
    // UP : 상행, DOWN : 하행
    public static Line makeLine(String name/*, Station upStation, Station downStation*/) {
        Line line = new Line(name);
//        StationRepository.addStation(upStation);
//        StationRepository.addStation(downStation);
        LineRepository.addLine(line);
//        SectionRepository.addNewLine(line, upStation, downStation);

        return line;
    }

    public static void deleteLine(String name) {
        SectionRepository.deleteLineInSection(LineRepository.get(name));
        LineRepository.deleteLineByName(name);
    }

}
