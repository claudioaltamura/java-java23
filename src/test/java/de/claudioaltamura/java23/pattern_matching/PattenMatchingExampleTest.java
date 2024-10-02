package de.claudioaltamura.java23.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PattenMatchingExampleTest {

    private PattenMatchingExample pattenMatchingExample = new PattenMatchingExample();

    @Test
    void guessWhat() {
        assertThat(pattenMatchingExample.guessSomething(1)).isEqualTo("It's a number.");
    }

    @Test
    void lowMediumHigh() {
        assertThat(pattenMatchingExample.isInt(1)).isTrue();
    }


}