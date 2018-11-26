package ru.sbt.benchmark.counters;

public class SynchronizedCounter implements Counter{

    private static long counter = 0;

    public synchronized long increment() {
        ++counter;
        return counter;
    }
}