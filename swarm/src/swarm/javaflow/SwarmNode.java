package swarm.javaflow;

import java.net.InetAddress;
import java.net.NetworkInterface;

import swarm.util.Misc;

public class SwarmNode {
	InetAddress address;

	public SwarmNode(InetAddress address) {
		this.address = address;
	}
	
	public boolean isLocal() {
		return false;
	}

	public static SwarmNode getLocal() {
		return new SwarmNode(Misc.getLocalAddress());
	}
}
