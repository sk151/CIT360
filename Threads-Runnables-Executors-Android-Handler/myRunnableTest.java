package ThreadsRunnablesExecutors;

public class myRunnableTest {

	public static void main(String[] args) {
		System.out.println("Executing program...");
		myRunnable r = new myRunnable();
     
		/*Creating a new thread and passing to it the executor to run
		 *as well as a name since this time default names were a little confusing.
		 */
		Thread thread1 = new Thread(r, "thread1");
		thread1.start();
     
		
		/* Trying to pass just a name to the thread, it worked
		 * since it ran the default (and empty) run() method that
		 * I'd normally override.
		 */
		try {
			Thread thread2 = new Thread("thread2");
			thread2.start();
		}
		catch (Exception e) {
			System.out.println("Bad parameters");
		}
		
		Thread thread3 = new Thread(r, "thread3");
		thread3.start();

		/* Found out that you can define a runnable in the parameter
		 * right when you start a thread of it and surprisingly, it worked.
		 * Doesn't seem like a very good thing to do, though.
		 */
		
		Thread nastyPathThread = new Thread(new Runnable() {
			public void run() {
					System.out.println("A thread inside of a thread is made!");
					Thread innerThread = new Thread(r, "innerThread");					
					innerThread.start();
			}
		}, "nastyPathThread");
		nastyPathThread.start();
	}
}
