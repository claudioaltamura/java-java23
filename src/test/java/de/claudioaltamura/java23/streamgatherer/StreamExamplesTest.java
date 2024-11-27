package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StreamExamplesTest {

    @Test
    void countLongWords() {
        var minLen = 4;
        var words = List.of("Java", "is", "a", "programming", "language", "and", "platform");
        new StreamExamples().countLongWords(words, minLen);
        assertThat(new StreamExamples().countLongWords(words, minLen)).isEqualTo(4);
    }

    @Test
    void groupByLength() {
        var words = List.of("Java", "is", "a", "programming", "language", "and", "platform");
        var result = new StreamExamples().groupByLength(words);
        assertThat(result.size()).isEqualTo(6);
    }
}