package ru.sbt.benchmark.counters;

import java.util.concurrent.Semaphore;

public class SemaphoreUnfairCounter implements Counter {

    private static long counter = 0;
    private static final Semaphore SEMAPHORE = new Semaphore(1, false);

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
