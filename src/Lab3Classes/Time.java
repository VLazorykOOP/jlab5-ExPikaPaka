package Lab3Classes;
import java.time.LocalTime;
import java.util.Comparator;


public class Time extends Triad {

    public Time(LocalTime time) {
        value1 = time.getHour();
        value2 = time.getMinute();
        value3 = time.getSecond();
    }

    public Time(int v1, int v2, int v3) {
        value1 = v1;
        value2 = v2;
        value3 = v3;
    }

    public void increment() {
        LocalTime time = LocalTime.of(value1, value2, value3);
        time = time.plusSeconds(1);

        value1 = time.getHour();
        value2 = time.getMinute();
        value3 = time.getSecond();
    }

    public void printValue() {
        System.out.printf("%02d:%02d:%02d", this.value1, this.value2, this.value3);
    }


    public String toString() {
        return String.format("Time: %02d:%02d:%02d", this.value1, this.value2, this.value3);
    }

    public int compareTo(Triad tm) {
        if (tm instanceof Time t) {
            if (value1 == t.value1 && value2 == t.value2 && value3 == t.value3)
                return 0;
            else if (value1 * 3600 + value2 * 60 + value3 < t.value1 * 3600 + t.value2 * 60 + t.value3)
                return -1;
            else
                return 1;
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