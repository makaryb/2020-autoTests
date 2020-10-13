package com.makaryb.sampletester.sample;

public class PrimitiveFunctionCalculator {

    public long add(long a, long b) {
        return a + b;
    }

    public long sub(long a, long b) {
        return a - b;
    }

    public long mul(long a, long b) {
        return a * b;
    }

    public double div(long a, long b) {
        double da = (double) a;
        double db = (double) b;
        return da / db;
    }
}
