package de.claudioaltamura.java23.streamgatherer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream examples.
 * see <a href="https://www.happycoders.eu/de/java/stream-gatherers/">stream-gatherers</a>
 */
public class StreamExamples {

    public long countLongWords(List<String> words, int minLength) {
        return words.stream()                       // ⟵ Source
                .map(String::length)                    // ⟵ Intermediate operation
                .filter(length -> length >= minLength)  // ⟵ Intermediate operation
                .count();                               // ⟵ Terminal operation
    }

    public Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream()                                 // ⟵ Source
                .map(String::toUpperCase)                         // ⟵ Intermediate operation
                .collect(Collectors.groupingBy(String::length));  // ⟵ Terminal operation
    }

}
