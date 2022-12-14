package subway.domain;

import view.OutputView;

import java.util.List;

public class SubwayInformationService {

    public void run() {
        printAllSubway();
    }

    private void printAllSubway() {
        List<Line> lines = LineRepository.lines();
        if (!lines.isEmpty()) {
            OutputView.printAllSubway(lines);
            return;
        }
        OutputView.printExceptionMessage(new IllegalArgumentException("등록된 노선이 없습니다."));
    }
}
