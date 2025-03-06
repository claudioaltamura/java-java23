package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DistinctByGathererTest {

    @Test
    void testDistinctBy() {
        var result = List.of("a", "b", "c", "a", "b", "c")
                .stream()
                .gather(GathererFactory.distinctBy(String::toUpperCase))
                .collect(Collectors.toList());
        assertEquals(List.of("a", "b", "c"), result);
    }

}