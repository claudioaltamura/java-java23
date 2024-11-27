package de.claudioaltamura.java23.streamgatherer;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

/**
 * Stream gatherer example.
 * see <a href="https://www.happycoders.eu/de/java/stream-gatherers/">stream-gatherers</a>
 */
public class StreamGathererExample {

    public <T, R> Gatherer<T, Void, R> mapping(Function<T, R> mapper) {
        return Gatherer.of(
                Gatherer.Integrator.ofGreedy(
                        (state, element, downstream) -> {
                            R mappedElement = mapper.apply(element);
                            return downstream.push(mappedElement);
                        }));
    }

    public List<Integer> toLengths(List<String> words) {
        return words.stream()
                .gather(mapping(String::length))
                .toList();
    }

    public List<List<String>> groupsOfThree(List<String> words) {
        return words.stream()
                .gather(Gatherers.windowFixed(3))
                .toList();
    }

    public <T> Gatherer<T, AtomicInteger, T> limiting(int maxSize) {
        return Gatherer.ofSequential(
                // Initializer
                AtomicInteger::new,

                // Integrator
                (state, element, downstream) -> {
                    if (state.getAndIncrement() < maxSize) {
                        return downstream.push(element);
                    } else {
                        return false;
                    }
                });
    }

    public List<String> firstThreeWords(List<String> words) {
        return words.stream()
                .gather(limiting(3))
                .toList();
    }

    public <T> Gatherer<T, List<T>, List<T>> windowing(int windowSize) {
        return Gatherer.ofSequential(
                // Initializer
                ArrayList::new,

                // Gatherer
                (state, element, downstream) -> {
                    state.add(element);
                    if (state.size() == windowSize) {
                        boolean result = downstream.push(List.copyOf(state));
                        state.clear();
                        return result;
                    } else {
                        return true;
                    }
                },

                // Finisher
                (state, downstream) -> {
                    if (!state.isEmpty()) {
                    downstream.push(List.copyOf(state));
                }
        });
    }

    public List<List<String>> groupWords(List<String> words, int groupSize) {
        return words.stream()
                .gather(windowing(groupSize))
                .toList();
    }
}
