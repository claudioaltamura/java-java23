package de.claudioaltamura.java23.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PattenMatchingExampleTest {

    private final PattenMatchingExample pattenMatchingExample = new PattenMatchingExample();

    @Test
    void guessWhat() {
        assertThat(pattenMatchingExample.guessSomething(1)).isEqualTo("It's a number.");
    }

    @Test
    void isInt() {
        assertThat(pattenMatchingExample.isInt(1)).isTrue();
    }

    @Test
    void lowMediumHigh() {
        assertThat(pattenMatchingExample.calculateSeverity(-1)).isEqualTo(Severity.UNKNOWN);
        assertThat(pattenMatchingExample.calculateSeverity(1)).isEqualTo(Severity.LOW);
        assertThat(pattenMatchingExample.calculateSeverity(4)).isEqualTo(Severity.MEDIUM);
        assertThat(pattenMatchingExample.calculateSeverity(7)).isEqualTo(Severity.HIGH);
    }

}