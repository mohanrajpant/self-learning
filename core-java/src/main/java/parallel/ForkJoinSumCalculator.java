package parallel;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private static final long THRESHOLD = 10_000;
    private final long[] numbers;
    private final int start;
    private final int end;

    ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        } else {
            ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
            leftTask.fork();
            ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length/2, end);
            final Long rightResult = rightTask.compute();
            final Long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }

    private long computeSequentially() {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }
}
