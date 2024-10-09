package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StreamGathererExampleTest {

    @Test
    void toLengths() {
        final var streamGathererExample = new StreamGathererExample();

        var result = streamGathererExample.toLengths(List.of("this", "is", "a", "list"));

        assertThat(result).containsAll(List.of(4,2,1,4));
    }
}