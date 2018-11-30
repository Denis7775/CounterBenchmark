package ru.sbt.benchmark.counters;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Counter {

    private static int counter = 0;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public long increment() {
        lock.lock();
        try {
            ++counter;
            return counter;
        }finally {
            lock.unlock();
        }
    }
}
