package ru.sbt.benchmark.counters;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter implements Counter{

    private long counter = 0;
    private final Semaphore SEMAPHORE = new Semaphore(1, true);

    public long increment() {
        try {
            SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            ++counter;
            return counter;
        }finally {
            SEMAPHORE.release();
        }
    }
}