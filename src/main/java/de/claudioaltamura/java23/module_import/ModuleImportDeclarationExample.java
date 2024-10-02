package de.claudioaltamura.java23.module_import;

import module java.base;

/*
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
*/

public class ModuleImportDeclarationExample {
    public static Map<Character, List<String>> groupByFirstLetter(String... values) {
        return Stream.of(values).collect(
                Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
    }
}
