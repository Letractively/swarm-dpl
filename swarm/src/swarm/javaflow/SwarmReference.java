package swarm.javaflow;

import org.apache.commons.javaflow.Continuation;

import swarm.ContinuationContext;

public abstract class SwarmReference<A> {
	SwarmNode location = SwarmNode.getLocal();

	public A get() {
		if (!location.isLocal()) {
			ContinuationContext cc = (ContinuationContext) Continuation.getContext();
			cc.switchTo = location;
			Continuation.suspend();
		}
		return getDelegate();
	}

	protected abstract A getDelegate();
	
}
