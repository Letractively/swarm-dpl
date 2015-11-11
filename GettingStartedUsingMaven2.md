# Introduction #

This page describes how to get started building and running the Swarm codebase and demos using Maven 2.0


# Details #

Maven 2.0 is not _required_ to build or use Swarm; there is a build shell script available with the sources. See the GettingStarted page for instructions on how to build Swarm without Maven.


## Building Swarm ##

### Requirements ###
  * Maven 2.x - these instructions were tested with 2.2.1
  * Java JDK 5 or above - these instructions were tested with Java 6, specifically Sun's 1.6.0\_16 JDK for Linux

All other requirements will be downloaded automatically by Maven on launching.

Both `mvn`, the Maven executable, and `java` must be in your path. Try `mvn -v` and `java -version` from the command line to make sure they are working.


As Swarm depends on Scala 2.8 and the continuations plugin, and these are not yet available in the Maven repositories, you'll need to install those to your local Maven repository, each one separately. The GettingStarted page has links to download the JARs you'll need.

Once you have the Scala compiler and the continuations plugin downloaded, run the following commands from the command line:

`mvn install:install-file -DgroupId=org.scala-lang -DartifactId=scala-library -Dversion=2.8.0-SNAPSHOT -Dpackaging=jar -Dfile=<PATH TO scala-library.jar>`

`mvn install:install-file -DgroupId=org.scala-lang -DartifactId=scala-compiler -Dversion=2.8.0-SNAPSHOT -Dpackaging=jar -Dfile=<PATH TO scala-compiler.jar>`

`mvn install:install-file -DgroupId=org.scala-lang -DartifactId=scala-plugin-continuations -Dversion=2.8.0-SNAPSHOT -Dpackaging=jar -Dfile=<PATH TO selectivecps-plugin.jar>`

`mvn install:install-file -DgroupId=org.scala-lang -DartifactId=scala-continuations-library -Dversion=2.8.0-SNAPSHOT -Dpackaging=jar -Dfile=<PATH TO selectivecps-library.jar>`

Each of these commands will copy the respective JAR files into your local Maven repository, which is located by default at `<user home>/.m2/repository`. If you decide to update the files at some point, you'll need to re-run these commands after you download or build the new compiler or continuations plugin.


### Build Steps ###

The project has a top-level POM file (`pom.xml`) in the project root.

To clean out build artifacts

`mvn clean`

To compile

`mvn compile`

All together

`mvn clean compile`

Extra options: Maven includes some standard command-line flags

`mvn -q <goal>` for less output

`mvn -o <goal>` to force Maven to use 3rd-party JAR files from your local repository. This means Maven won't go online to check for updates. Safe to use if you already have the latest versions installed.

`mvn -X <goal>` to show _extensive_ debug output about the build process. You almost never want to use this. If you do, redirect or pipe the output somewhere.

# Running the Swarm Demos #

Make sure you read GettingStarted first; in particular, make sure that you've tested it outside of Maven before trying to run the demos with Maven. Note that the demos aren't dependent on Maven; these instructions are just a convenience if you want to avoid using a shell script. In particular, using Maven you don't need to worry about setting up your classpath.

## The Explicit Move To Demo ##
To execute the listener, in one console, run

`mvn -q exec:java -Dexec.mainClass="swarm.demos.Listen" -Dexec.args="9997"`


To execute the server/sender, in another console, run

`mvn -q exec:java -Dexec.mainClass="swarm.demos.ExplicitMoveTo1" -Dexec.args="9998"`