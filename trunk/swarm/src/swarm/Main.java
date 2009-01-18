package swarm;

import org.apache.commons.javaflow.Continuation;

import swarm.javaflow.ContTest;

public class Main {
	public static void main(String[] args) {
		Continuation c = Continuation.startWith(new ContTest());
		System.out.println("returned a continuation");
		Continuation d = Continuation.continueWith(c);
		System.out.println("returned another continuation");
	}
}
