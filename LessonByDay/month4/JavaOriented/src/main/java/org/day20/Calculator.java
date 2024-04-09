package org.day20;

public interface Calculator {
    public int plus(int i, int j);
    public int multiple(int i, int j);

    default public int exec(int i, int j){
        return i - j;
    }
}

class B implements Calculator {
    public B() {
        super();
    }

    @Override
    public int plus(int i, int j) {
        return 0;
    }

    @Override
    public int multiple(int i, int j) {
        return 0;
    }

}

class C implements Calculator {
    @Override
    public int plus(int i, int j) {
        return 0;
    }

    @Override
    public int multiple(int i, int j) {
        return 0;
    }

}