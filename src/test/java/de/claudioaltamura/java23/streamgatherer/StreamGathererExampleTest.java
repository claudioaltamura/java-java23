package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StreamGathererExampleTest {

    private final StreamGathererExample streamGathererExample = new StreamGathererExample();

    @Test
    void toLengths() {
        var result = streamGathererExample.toLengths(List.of("this", "is", "a", "list"));

        assertThat(result).containsAll(List.of(4,2,1,4));
    }

    @Test
    void groupOfThree() {
        final List<List<String>> result = streamGathererExample.groupsOfThree(List.of("Hello", "beautiful", "world", "You", "are", "nice"));

        assertThat(result).hasSize(2);
        assertThat(result.getFirst()).contains("Hello", "beautiful", "world");
        assertThat(result.getLast()).contains("You", "are", "nice");
    }

    @Test
    void firstThreeWords() {
        final List<String> result = streamGathererExample.firstThreeWords(List.of("Hello", "beautiful", "world", "You", "are", "nice"));

        assertThat(result).contains("Hello", "beautiful", "world");
    }

    @Test
    void groupWords() {
        var groupSize = 2;
        final List<List<String>> result = streamGathererExample.groupWords(List.of("Hello", "beautiful", "world", "You", "are", "nice"), groupSize);

        assertThat(result).hasSize(3);
        assertThat(result.getFirst()).contains("Hello", "beautiful");
        assertThat(result.get(1)).contains("world", "You");
        assertThat(result.getLast()).contains("are", "nice");
    }
}