package Lab3Classes;

public abstract class Triad implements Comparable<Triad> {
    protected int value1;
    protected int value2;
    protected int value3;


    public int getValue1() {
        return value1;
    }
    public int getValue2() {
        return value2;
    }
    public int getValue3() {
        return value3;
    }

    public void settValue1(int v) {
        value1 = v;
    }
    public void setValue2(int v) {
        value2 = v;
    }
    public void setValue3(int v) {
        value3 = v;
    }

    abstract void increment();
    abstract void printValue();
}
