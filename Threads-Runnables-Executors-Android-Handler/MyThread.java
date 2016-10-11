package ThreadsRunnablesExecutors;

/*This example creates 3 threads that count to 10,
 * each starting at different points (1,5,9) 
 * and counting at the same time every second
 */
public class MyThread {
	
	public static void main(String[] args){
		
       		/*a nasty path to pass a parameter to a thread:
			 *ThreadTest aThread =  new ThreadTest();
			 *aThread(1).start();
			 */
		
			//a happy path for it
       		new ThreadTest(1).start();
       		new ThreadTest(5).start();
       		new ThreadTest(9).start();
	}
}	

class ThreadTest extends Thread {
	int startLine;
	
	//without this constructor, the parameter won't get passed
	public ThreadTest(int input){
		startLine = input;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()
				+ " is counting to 10 starting at "
				+ startLine);
		for (int i = startLine; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try{
				ThreadTest.sleep(1500);
				//trying to use nanoseconds here
				ThreadTest.sleep(0, 999999);
			}	
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " is finished!");
	}
}
