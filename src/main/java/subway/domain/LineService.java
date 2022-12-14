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
            // TODO : station maker가 만들어서 객체 반환 & 레포 등록하도록 변경
            Station station =  new Station(stationName);
            StationRepository.addStation(station);
            return station;
        }
    }

    public List<Line> getLines() {
        if (LineRepository.isEmpty()) {
            throw new IllegalArgumentException("등록된 노선이 없습니다.");
        }
        return LineRepository.lines();
    }

    public void addSection(String lineName, String stationName, int order) {
        Line line = LineRepository.getLineByName(lineName);
        Station station = getStation(stationName);
        if (line.has(station)) {
            throw new IllegalArgumentException("이미 노선에 존재하는 역입니다.");
        }
        line.add(station, order - 1);
    }

    public void deleteSection(String deletingLineName, String deletingStationName) {
        // TODO :뭔가 잘못됐음
        Line line = LineRepository.getLineByName(deletingLineName);
        Station station = StationRepository.getStationByName(deletingStationName);
        if (line.isDeletable()) {
            line.deleteStation(station);
        }
        throw new IllegalArgumentException("한 노선에는 최소 두 개 이상의 역이 존재해야 합니다.");
    }
}
