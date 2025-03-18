package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BuiltInGathererTest {

    @Test
    void fold() {
        var result = Stream.of(1, 2, 4, 5).gather(Gatherers.fold(()->0, (a, b) -> a + b)).toList();
        assertThat(result.getFirst()).isEqualTo(12);
    }

    @Test
    void mapConcurrent() {
        var result = Stream.of(1, 2, 4, 5).gather(Gatherers.mapConcurrent(4, a -> a * 2)).toList();
        assertThat(result).containsExactly(2, 4, 8, 10);
    }

    @Test
    void windowFixed() {
        var result = Stream.of(1, 2, 4, 5).gather(Gatherers.windowFixed(2)).toArray();
        assertThat(result).containsExactly(List.of(1, 2), List.of(4, 5));
    }

    @Test
    void windowSliding() {
        var result = Stream.of(1, 2, 3, 4, 5).gather(Gatherers.windowSliding(2)).toArray();
        assertThat(result).containsExactly(List.of(1, 2), List.of(2, 3), List.of(3, 4), List.of(4, 5));
    }
}
