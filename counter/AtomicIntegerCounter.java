package ru.sbt.benchmark.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements Counter{

    private AtomicInteger counter = new AtomicInteger();

    public long increment() {

        return counter.incrementAndGet();
    }
}
