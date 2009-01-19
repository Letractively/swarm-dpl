package swarm.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Random;

public class Misc {
	public static void main(String[] args) throws SocketException {
		System.out.println(getLocalAddress());
	}
	
	public static Random random = new Random();
	
	public static InetAddress getLocalAddress() {
		try {
			for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
				for (InetAddress ia : Collections.list(ni.getInetAddresses())) {
					if (!ia.isLoopbackAddress() && !ia.isAnyLocalAddress() && !ia.isLinkLocalAddress()) {
						return ia;
					}
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
