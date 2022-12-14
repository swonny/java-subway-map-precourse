package subway.domain;

import java.util.List;

public class LineService {
    public void deleteLine(String deletingLine) {
        if (!LineRepository.deleteLineByName(deletingLine)) {
            throw new IllegalArgumentException("삭제하려는 노선이 없습니다.");
        }
    }

    public void addLine(Line line, String startStationName, String endStationName) {
        // TODO : 역 이름 두글자 이하일 떄 체크 안하는듯
        if (LineRepository.has(line)) {
            throw new IllegalArgumentException("중복된 이름의 노선을 등록할 수 없습니다.");
        }
        Station startStation = getStation(startStationName);
        Station endStation = getStation(endStationName);
        line.addNewStation(startStation, endStation);
        LineRepository.addLine(line);
    }

    private Station getStation(String stationName) {
        try {
            return StationRepository.getStationByName(stationName);
        } catch (IllegalArgumentException exception) {
            return new Station(stationName);
        }
    }

    public List<Line> getLines() {
        if (LineRepository.isEmpty()) {
            throw new IllegalArgumentException("등록된 노선이 없습니다.");
        }
        return LineRepository.lines();
    }

    public void addSection(Line lineName, Station stationName, int order) {

    }

    public void deleteSection(Line deletingLine, Station deletingStation) {

    }
}
