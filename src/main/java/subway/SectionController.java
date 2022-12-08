package subway;

import subway.domain.*;

public class SectionController {
    public void addSection(String lineName, String station, int stationOrder) {
        SectionRepository.addStationToSection(
                LineRepository.get(lineName),
                StationRepository.get(station),
                stationOrder
        );
    }

    public void deleteStationInSection(String lineName, String stationName) {
        SectionRepository.delete(LineRepository.get(lineName), StationRepository.get(stationName));
    }

}
