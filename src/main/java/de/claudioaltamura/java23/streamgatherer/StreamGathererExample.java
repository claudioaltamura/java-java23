package de.claudioaltamura.java23.streamgatherer;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
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

    public <T> Gatherer<T, AtomicReference<T>, T> maximumBy(Comparator<T> comparator) {
        return Gatherer.of(
                // Initializer
                AtomicReference::new,

                // Integrator
                Gatherer.Integrator.ofGreedy(
                        (state, element, downstream) -> {
                            T bestElement = state.get();
                            if (bestElement == null || comparator.compare(element, bestElement) > 0) {
                                state.set(element);
                            }
                            return true;
                        }),

                // Combiner
                (state1, state2) -> {
                    T bestElement1 = state1.get();
                    T bestElement2 = state2.get();

                    if (bestElement1 == null) {
                        return state2;
                    } else if (bestElement2 == null) {
                        return state1;
                    } else if (comparator.compare(bestElement1, bestElement2) > 0) {
                        return state1;
                    } else {
                        return state2;
                    }
                },

                // Finisher
                (state, downstream) -> {
                    T bestElement = state.get();
                    if (bestElement != null) {
                        downstream.push(bestElement);
                    }
                });
    }

    public Optional<String> getLongest(List<String> words) {
        return words.parallelStream()
                .gather(maximumBy(Comparator.comparing(String::length)))
                .findFirst();
    }

}