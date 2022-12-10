package subway.domain;

public class StationMaker {
    public static Station make(String name) {
        validate(name);
        Station newStation = new Station(name);
        return newStation;
    }

    private static void validate(String name) {
        if (StationRepository.has(name)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 이름의 역이 존재합니다.");
        }
    }
}
