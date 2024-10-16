package de.claudioaltamura.java23.flexible_constructor_bodies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChildTest {

    @Test
    void shouldCreateAChild() {
        assertDoesNotThrow(() -> new Child(1,2));
    }

    @Test
    void shouldNotCreateAChild() {
        assertThrows(IllegalArgumentException.class, () -> new Child(-1,2));
    }


}