package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ReduceByGathererTest {

    @Test
    void testReduceBy() {
        var result = List.of("a", "b", "C", "A", "b", "C")
                .stream()
                .gather(GathererFactory.reduceBy(String::toLowerCase, String::concat))
                .collect(Collectors.toList());
        assertEquals(List.of("aA", "bb", "CC"), result);
    }

}