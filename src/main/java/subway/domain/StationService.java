package subway.domain;

import java.util.List;

public class StationService {
    public void addStation(String addingStation) {
        Station newStation = new Station(addingStation);
        if (StationRepository.has(newStation)) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다. ");
        }
        StationRepository.addStation(newStation);
    }

    public void deleteStation(String deletingStation) {
        if (!StationRepository.deleteStation(deletingStation)) {
            throw new IllegalArgumentException("등록된 지하철 역이 없습니다.");
        }
    }
}
