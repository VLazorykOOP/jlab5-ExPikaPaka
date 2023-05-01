package Lab3Classes;

import java.time.LocalDate;
import java.util.Comparator;

public class Date extends Triad {
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
        if (dt instanceof Date d) {
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

