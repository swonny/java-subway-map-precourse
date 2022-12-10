package study;

import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.LineMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void test() {
        List<String> test = Stream.of(1, 2, 3)
                .map(number -> Integer.toString(number))
                .collect(Collectors.toList());
        assertThat(test.remove(0)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int sum = IntStream.range(1, 4)
                .reduce(0, Integer::sum);
        assertThat(sum).isEqualTo(1);
    }

    @Test
    public void test_collections_contains() {
        Line line = new Line("4호선");
        List<Line> lines = Stream.of("2호선", "3호선")
                .map(LineMaker::make)
                .collect(Collectors.toList());
        lines.add(line);
        System.out.println(lines.contains(line));

        Stream<String> stream = Stream.generate(() -> "Echo").limit(5);
        stream.forEach(System.out::println);
    }
}
