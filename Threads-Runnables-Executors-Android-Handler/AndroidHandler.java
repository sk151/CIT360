import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

// Moving a progress bar using an android handler

public class MainActivity extends Activity {
	// Creating the handler and the progress bar
    private Handler myHandler;
    private ProgressBar myProgressBar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myHandler = new Handler();
        myProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
    }
    public void Task (View myView) {
        new Thread(new makeProgress()).start();
    }

    // This is where the handler comes into play
    class makeProgress implements Runnable {
        public void run() {
            for (int i = 0; i <= 10; i++) {
                int value = i;
                try {
                    Thread.sleep(1234);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /* Making a handler that's tied to a runnable
                 * that moves a progress bar
                 */
                myHandler.post(new Runnable() {
                    public void run() {
                        progressBar.setProgress(value);
                    }
                });
            }
        }
    }
    /* Nasty path for moving the progress bar
     * (handler wasn't used)
    public class makeProgress implements Runnable {
    	public void run() {
    		for (int i = 0; i <= 10; i++) {
    			int value = i;
                try {
                    Thread.sleep(1234);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressBar.setProgress(value);
    		}
    	}
    }
    */
}
