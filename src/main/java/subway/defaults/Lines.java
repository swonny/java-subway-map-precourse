package subway.defaults;

public enum Lines {
    LINE_NUMBER_2("2호선", "교대역", "역삼역"),
    LINE_NUMBER_3("3호선","교대역", "메봉역"),
    SHINBUNDANG("신분당선","강남역", "양재시민의숲역");

    private String name;
    private String up;
    private String down;

    Lines(String name, String up, String down) {
        this.name = name;
        this.up = up;
        this.down = down;
    }

    public static String getUp(String name) {
        return findStation(name).up;
    }

    public static String getDown(String name) {
        return findStation(name).down;
    }

    private static Lines findStation(String name) {
        for (Lines findStation : Lines.values()) {
            if (findStation.name.equals(name)) {
                return findStation;
            }
        }
        return null;
    }
}
