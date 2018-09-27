package parallel;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {

    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) throws IOException {

        System.out.println("iterativeSum(10_000_000L)");
        measureAndLogPerformance(() -> iterativeSum(10_000_000L));

        System.out.println("parallelSumUsingStreamIterate(10_000_000L)");
        measureAndLogPerformance(() -> parallelSumUsingStreamIterate(10_000_000L));

        System.out.println("parallelSumUsingStreamRange(10_000_000L)");
        measureAndLogPerformance(() -> parallelSumUsingStreamRange(10_000_000L));

        System.out.println("forkJoinSum(10_000_000L)");
        measureAndLogPerformance(() -> forkJoinSum(10_000_000L));
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelSumUsingStreamIterate(long n) {
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
//            .parallel()
            .reduce(0L, Long::sum);
    }

    public static long parallelSumUsingStreamRange(long n) {
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(0L, Long::sum);
    }

    public static Long forkJoinSum(long n) {
        long [] numbers = LongStream.rangeClosed(0, n).toArray();
        final ForkJoinTask<Long> forkJoinTask = new  ForkJoinSumCalculator(numbers);
        return FORK_JOIN_POOL.invoke(forkJoinTask);
    }


    public static <T> void measureAndLogPerformance(LongSupplier supplier) {
        long fastest = Long.MAX_VALUE;
        long result = 0;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            result = supplier.getAsLong();
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("The result is " + result);
        System.out.println("The processing times is " + fastest + " msecs");
        System.out.println();
    }
}
