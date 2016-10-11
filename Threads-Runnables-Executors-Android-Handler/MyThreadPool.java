package ThreadsRunnablesExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyThreadPool {
    
	public static void main(String[] args) {
		Executor myExecutor = Executors.newFixedThreadPool(5);
		try {
			System.out.println("Making 3 threads out of the pool of 5");
			for(int i = 0; i < 3; i++){
				
				// Trying to assign a thread a name, they are all still called "main"
				Runnable myRunnable = new Thread("Thread #" + i);
				myExecutor.execute(myRunnable);
				System.out.println("Executing thread " + Thread.currentThread().getName());
			}
			// Trying to exceed the number of allowed threads in the pool
			System.out.println("Making 8 threads out of the pool of 5");
			for(int i = 0; i < 8; i++){
				Runnable myRunnable = new Thread("Thread #" + i);
				myExecutor.execute(myRunnable);
				System.out.println("Executing thread " + Thread.currentThread().getName());
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
		// It's not needed for an Executor
		// but I'd have to use shutdown() it with an ExecutorService
		// myExecutor.shutdown();
        
	}
}
