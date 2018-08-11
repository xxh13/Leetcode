package concurrencyDemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * try to use fork join
 */
public class ForkJoinDemo extends RecursiveTask {

	private static final int THRESHOLD = 5;
	private int n;

	ForkJoinDemo(int n) {
		this.n = n;
	}

	@Override
	protected Object compute() {
		System.out.println(Thread.currentThread().getName());
		if (n < THRESHOLD) {
			return seqFib(n);
		} else {
			ForkJoinDemo f1 = new ForkJoinDemo(n - 1);
			ForkJoinDemo f2 = new ForkJoinDemo(n - 2);
			f1.fork();
			f2.fork();
			Integer result1 = (Integer) f1.join();
			Integer result2 = (Integer) f2.join();
			return result1 + result2;
		}
	}

	private int seqFib(int n) {
		if (n <= 1) return n;
        else return seqFib(n - 1) + seqFib(n - 2);
	}

	public static void main(String[] args) {
		try {
			ForkJoinPool forkJoinPool =new ForkJoinPool();
			ForkJoinDemo demo = new ForkJoinDemo(15);
			Future result = forkJoinPool.submit(demo);
			System.out.println(result.get());
		} catch (Exception e) {

		}
	}


}
