package de.claudioaltamura.java23.streamgatherer;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Gatherer;

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

}