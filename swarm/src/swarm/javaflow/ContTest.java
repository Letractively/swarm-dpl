package swarm.javaflow;

import org.apache.commons.javaflow.Continuation;

public class ContTest implements Runnable {
	  public void run() {
		System.out.println("started!");
		for (int i = 0; i < 10; i++)
			echo(i);
	}

	private void echo(int x) {
		System.out.println(x);
		Continuation.suspend();
	}
}
