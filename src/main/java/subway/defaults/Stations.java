package subway.defaults;

import java.util.HashMap;
import java.util.List;

public class Stations {

    public static HashMap<String, List<String>> getStations() {
        HashMap<String, List<String>> lines = new HashMap<>();
        lines.put("2호선", List.of("교대역", "강남역", "역삼역"));
        lines.put("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        lines.put("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));
        return lines;
    }
}