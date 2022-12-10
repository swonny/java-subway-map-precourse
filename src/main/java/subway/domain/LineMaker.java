package subway.domain;

public class LineMaker {
    public static Line make(String name) {
        Line line = new Line(name);
        LineRepository.addLine(line);
        return line;
    }
}
