package de.claudioaltamura.java23.flexible_constructor_bodies;

public class Child extends Parent {

    private final int b;

    public Child(int a, int b) {
        //this is now allowed!
        if(a < 0) throw new IllegalArgumentException("a must be => 0");
        if(b < 0) throw new IllegalArgumentException("b must be => 0");
        this.b = b;
        super(a);
    }

    public int getB() {
        return b;
    }
}
