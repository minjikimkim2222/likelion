package org.day24;

import java.util.Objects;

// SetExam 관련 예제코드
public class Pen {
    private String color;
    public Pen(String color){
        this.color = color;
    }
    @Override
    public String toString(){
        return color + " pen";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pen pen)) return false;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
