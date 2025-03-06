package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstGathererTest {

    @Test
    void testFindFirst() {
        var result = List.of("a", "c", "d", "a", "b", "c")
                .stream()
                .gather(GathererFactory.findFirst(e-> e.equals("b")))
                .collect(Collectors.toList());
        assertEquals(List.of("b"), result);
    }

}