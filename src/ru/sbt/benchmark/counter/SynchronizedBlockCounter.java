package ru.sbt.benchmark.counters;

public class SynchronizedBlockCounter implements Counter {
    private static long counter = 0;
    private static final Object object = new Object();

    public long increment() {
        synchronized (object) {
            ++counter;
            return counter;
        }
    }
}
