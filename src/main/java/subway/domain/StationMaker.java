package subway.domain;

public class StationMaker {
    public static Station make(String name) {
        // TODO: 유효성 검사 추가
//        validate(name);
        if (StationRepository.has(name)) {
            throw new IllegalArgumentException();
        }
        Station newStation = new Station(name);
//        StationRepository.addStation(newStation);
        return newStation;
    }
}
