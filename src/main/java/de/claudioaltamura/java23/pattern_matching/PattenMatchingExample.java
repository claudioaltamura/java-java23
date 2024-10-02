package de.claudioaltamura.java23.pattern_matching;

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

}
