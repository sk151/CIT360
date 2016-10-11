package ThreadsRunnablesExecutors;

public class myRunnable implements Runnable {

	public void run() {
		for (int i = 5; i > 0; i--) {
			System.out.println(Thread.currentThread().getName() + " is over in " + i);
		}
		System.out.println(Thread.currentThread().getName() + " is done!");
	}
}
