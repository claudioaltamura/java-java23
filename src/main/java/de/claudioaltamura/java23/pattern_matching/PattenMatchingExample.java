package de.claudioaltamura.java23.pattern_matching;

import static de.claudioaltamura.java23.pattern_matching.Severity.*;

public class PattenMatchingExample {

    public String guessSomething(Object obj) {
        return switch (obj) {
            case String s when s.length() >= 5 -> "5 or more chars.";
            case Integer i -> "It's a number.";
            default -> "I don't have a clue.";
        };
    }

    public boolean isInt(Object value) {
        return value instanceof int i;
    }

    public Severity calculateSeverity(int counter) {
        return switch(counter) {
            case 1,2,3 -> LOW;
            case 4,5,6 -> MEDIUM;
            case 7,8,9 -> HIGH;
            default -> UNKNOWN;
        };
    }

}
