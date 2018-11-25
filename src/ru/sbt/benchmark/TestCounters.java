package ru.sbt.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.sbt.benchmark.counters.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 7)
@Measurement(iterations = 7)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class TestCounters {

    private Counter atomicIntegerCounter;
    private Counter semaphoreCounter;
    private Counter synchronizedCounter;

    public TestCounters() {
        atomicIntegerCounter = new AtomicIntegerCounter();
        semaphoreCounter = new SemaphoreCounter();
        synchronizedCounter = new SynchronizedCounter();
    }

    public static void main(String[] args) throws Exception{
        Options options = new OptionsBuilder()
                .include(TestCounters.class.getSimpleName())
                .resultFormat(ResultFormatType.CSV)
                .result("C:\\Users\\kudya\\IdeaProjects\\hw3\\benchmark_result.csv")
                .mode(Mode.Throughput)
                .forks(1)
                .warmupIterations(7)
                .measurementIterations(7)
                .build();
        new Runner(options).run();
    }


    @Benchmark
    @Threads(2)
    public void incAtomic() { atomicIntegerCounter.increment(); }

    @Benchmark
    @Threads(4)
    public void incAtomic1() {
        atomicIntegerCounter.increment();
    }

    @Benchmark
    @Threads(8)
    public void incAtomic2() {
        atomicIntegerCounter.increment();
    }

    @Benchmark
    @Threads(16)
    public void incAtomic3() {
        atomicIntegerCounter.increment();
    }



    @Benchmark
    @Threads(2)
    public void incSem() { semaphoreCounter.increment(); }

    @Benchmark
    @Threads(4)
    public void incSem1() {
        semaphoreCounter.increment();
    }

    @Benchmark
    @Threads(8)
    public void incSem2() {
        semaphoreCounter.increment();
    }

    @Benchmark
    @Threads(16)
    public void incSem3() {
        semaphoreCounter.increment();
    }



    @Benchmark
    @GroupThreads(2)
    public void incSync() {
        synchronizedCounter.increment();
    }

    @Benchmark
    @Threads(4)
    public void incSync1() {
        synchronizedCounter.increment();
    }

    @Benchmark
    @GroupThreads(8)
    public void incSync2() {
        synchronizedCounter.increment();
    }

    @Benchmark
    @Threads(16)
    public void incSync3() {
        synchronizedCounter.increment();
    }

}
