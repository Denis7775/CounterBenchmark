package ru.sbt.benchmark.counters;

public class SynchronizedCounter implements Counter{

    private long counter = 0;

    public synchronized long increment() {
        ++counter;
        return counter;
    }
}