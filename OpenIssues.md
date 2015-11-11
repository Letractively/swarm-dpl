## Arranging data ##
Swarm must find a way to adaptively arrange data on servers to minimize the number of times a thread must jump from one computer to the other.

Ian has posted a proposal for this to our mailing list, and more recently done some [initial work](http://groups.google.com/group/swarm-discuss/browse_thread/thread/4018d94716d00a20?hl=en) on simulation.  View the proposal for an algorithm [here](http://groups.google.com/group/swarm-discuss/browse_thread/thread/b51f0d961fa37909), and if interested - please join the conversation!

## Concurrency ##
Ian proposed examining "software transactional memory" as a way to prevent threads from interfering with each-other in bad ways.  This spawned a discussion on the pros and cons of various approaches.  Read the thread [here](http://groups.google.com/group/swarm-discuss/browse_thread/thread/9919e42e539e2c0a).

## Universal code access ##
Swarm requires that every Swarm node be running the same codebase.

I think this can be achieved by hooking into the JVM's classloader and making it retrieve packages on-demand as they are needed.  This concept is inspired by the [Zero Install](http://0install.net/) package management system.

This would probably involve having some kind of public crypto key in the package name as a unique identifier - eg:

```
package swarm.bR781Z1h7.wombat.3.0
```