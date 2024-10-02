package de.claudioaltamura.java23.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PattenMatchingExampleTest {

    @Test
    void guessWhat() {
        assertThat(new PattenMatchingExample().guessSomething(1)).isEqualTo("It's a number.s");
    }

}