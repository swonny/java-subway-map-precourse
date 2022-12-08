package subway.domain;

import java.util.*;

public class LineMaker {
    // UP : 상행, DOWN : 하행
    public static HashMap<Line, List<Station>> makeLine(String name, String up, String down) {
        HashMap newLine = new HashMap();
        newLine.put(new Line(name), Arrays.asList(new Station(up), new Station(down)));
        return newLine;
    }
}
