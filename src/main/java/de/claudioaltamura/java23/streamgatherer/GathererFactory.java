package de.claudioaltamura.java23.streamgatherer;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class GathererFactory {

    private GathererFactory() {
    }

    public static <T, P> DistinctByGatherer<T, P> distinctBy(Function<T, P> extractor) {
        return new DistinctByGatherer<>(extractor);
    }

    public static <T, P> ReduceByGatherer<T, P> reduceBy(Function<T, P> extractor, BiFunction<T, T, T> reducer) {
        return new ReduceByGatherer<>(extractor, reducer);
    }

    public static <T, B extends Comparable<B>> MaxByGatherer<T, B> maxBy(Function<T, B> extractor) {
        return new MaxByGatherer<>(extractor);
    }

    public static <T> FindFirstGatherer<T> findFirst(Predicate<T> predicate) {
        return new FindFirstGatherer<>(predicate);
    }
}
