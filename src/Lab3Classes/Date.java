package Lab3Classes;

import java.time.LocalDate;

public class Date implements Triad {
    protected int value1;
    protected int value2;
    protected int value3;

    public Date(LocalDate date) {
        value1 = date.getDayOfMonth();
        value2 = date.getMonthValue();
        value3 = date.getYear();
    }

    public Date(int v1, int v2, int v3) {
        value1 = v1;
        value2 = v2;
        value3 = v3;
    }

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

    public void increment() {
        LocalDate date = LocalDate.of(value3, value2, value1);
        date = date.plusDays(1);

        value1 = date.getDayOfMonth();
        value2 = date.getMonthValue();
        value3 = date.getYear();
    }

    public void printValue() {
        System.out.printf("%02d/%02d/%04d", this.value1, this.value2, this.value3);
    }

    public String toString() {
        return String.format("Date: %02d/%02d/%04d", this.value1, this.value2, this.value3);
    }


    public int compareTo(Triad dt) {
        if (dt instanceof Time d) {
            if (this.value3 == d.value3) {
                if (this.value2 == d.value2) {
                    return Integer.compare(this.value1, d.value1);
                }
                return Integer.compare(this.value2, d.value2);
            }
            return Integer.compare(this.value3, d.value3);
        } else {
            return -1;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Date other)) {
            return false;
        }
        return this.value1 == other.value1 && this.value2 == other.value2 && this.value3 == other.value3;
    }
}

