package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StreamExamplesTest {

    @Test
    void countLongWords() {
        var minLen = 4;
        var words = List.of("Java", "is", "a", "programming", "language", "and", "platform");

        var streamExamples = new StreamExamples();

        assertThat(streamExamples.countLongWords(words, minLen)).isEqualTo(4);
    }

    @Test
    void groupByLength() {
        var words = List.of("Java", "is", "a", "programming", "language", "and", "platform");

        var result = new StreamExamples().groupByLength(words);

        assertThat(result.size()).isEqualTo(6);
    }
}