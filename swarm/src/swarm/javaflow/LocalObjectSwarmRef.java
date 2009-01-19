package swarm.javaflow;

import java.util.HashMap;

import swarm.util.Misc;

public class LocalObjectSwarmRef<A> extends SwarmReference<A> {
	long localId;
	static HashMap<Long, Object> localObjectStore;

	public LocalObjectSwarmRef(A object) {
		long id = Misc.random.nextLong();
		while (localObjectStore.containsKey(id)) {
			id = Misc.random.nextLong();
		}
		localId = id;
		localObjectStore.put(id, object);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected A getDelegate() {
		return (A) localObjectStore.get(localId);
	}
}
