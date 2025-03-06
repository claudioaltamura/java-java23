package de.claudioaltamura.java23.streamgatherer;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MaxByGathererTest {

    private static final Currency EUR = Currency.getInstance("EUR");
    private static final Currency USD = Currency.getInstance("USD");

    @Test
    void testMaxGatherer() {
        var result = List.of(
                    new Money(BigDecimal.valueOf(12), EUR),
                        new Money(BigDecimal.valueOf(10), USD)
                )
                .stream()
                .parallel()
                .gather(GathererFactory.maxBy(Money::amount))
                .collect(Collectors.toList());
        assertEquals(List.of(new Money(BigDecimal.valueOf(12), EUR)), result);
    }
}