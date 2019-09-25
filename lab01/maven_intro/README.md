# 1.1 - Maven

**Vasco António Lopes Ramos | LEI | nmec 88931**


## Installing maven
   I tried using the web tutorial given in the guidelines, but it didn't work for me, so what I did was:

	 1. sudo apt update
	 2. sudo apt install maven
	 3. mvn -version (installied maven 3.6.0 successfully -> the command work)

   To update to maven 3.6.2: 

	 1. wget https://www-us.apache.org/dist/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.tar.gz -P /tmp
	 2. sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt
	 3. sudo ln -s /opt/apache-maven-3.6.2 /opt/maven
	 4. sudo nano /etc/profile.d/maven.sh
	 5. cat /etc/profile.d/maven.sh
	 6. sudo chmod +x /etc/profile.d/maven.sh
	 7. source /etc/profile.d/maven.sh
	 8. mvn -version (installed maven 3.6.2 successfully -> the command work)


## Maven in 5 Minutes

### Creating 'my_app' project:
`$ mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4  -DinteractiveMode=false`

**Description:**
 - The `src/main/java` directory contains the project source code.
 -  The `src/test/java` directory contains the test source.
 -  The `pom.xml` file is the project's Project Object Model, or POM.

**The POM:**

The `pom.xml` file is the core of a project's configuration in Maven. It is a single configuration file that contains the majority of information required to build a project.

### Quick commands:

 - Check Maven Version (and check if everything is ok): `$ mvn --version`
 - Create Project (It will be created a directory 'my-app'): `mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`
 - Build the project: `$ mvn package`
 - Test and execute project: `$ java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App`

**Naming Conventions:** [https://maven.apache.org/guides/mini/guide-naming-conventions.html](https://maven.apache.org/guides/mini/guide-naming-conventions.html)


## Creating a new Project
Example with IPMA Weather API ([http://api.ipma.pt/](http://api.ipma.pt/))

 1. Customize POM Metadata: [https://books.sonatype.com/mvnex-book/reference/customizing-sect-customizing-project-info.html](https://books.sonatype.com/mvnex-book/reference/customizing-sect-customizing-project-info.html)
 2.  Setting Java Version: [https://www.baeldung.com/maven-java-version](https://www.baeldung.com/maven-java-version)
 3. Run Project: 
	 ```
	 $ mvn clean package
	 $ mvn exec:java -Dexec.mainClass="com.Weather.Main"
	```


## Running Maven Tools

#### Maven Phases

These are the most common _default_ lifecycle phases executed.

-   **validate**: validate the project is correct and all necessary information is available
-   **compile**: compile the source code of the project
-   **test**: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
-   **package**: take the compiled code and package it in its distributable format, such as a JAR.
-   **integration-test**: process and deploy the package if necessary into an environment where integration tests can be run
-   **verify**: run any checks to verify the package is valid and meets quality criteria
-   **install**: install the package into the local repository, for use as a dependency in other projects locally
-   **deploy**: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

There are two other Maven lifecycles of note beyond the _default_ list above. They are

-   **clean**: cleans up artifacts created by prior builds (`mvn clean`)

-   **site**: generates site documentation for this project (`mvn site`)

Phases are actually mapped to underlying goals. The specific goals executed per phase is dependant upon the packaging type of the project. For example, _package_ executes _jar:jar_ if the project type is a JAR, and _war:war_ if the project type is - you guessed it - a WAR.

An interesting thing to note is that phases and goals may be executed in sequence.

`1.  mvn clean dependency:copy-dependencies package`

This command will clean the project, copy dependencies, and package the project (executing all phases up to _package_, of course).

#### Generating the Site

`1.  mvn site`

This phase generates a site based upon information on the project's pom. You can look at the documentation generated under `target/site`.


## Final Questions:

### What is a **Maven Goal?**
A goal is the single unit of task which does some real work.
All goals are provided by plugins, either by default plugins or by user defined plugins (configured in pom file).

**Each phase is a sequence of goals, and each goal is responsible for a specific task.**
When we run a phase – all goals bound to this phase are executed in order.

### What are the main "Maven Goals" and what is the respective excecution order?

Here are some of the phases and default goals bound to them:
-   _compiler:compile_ – the _compile_ goal from the _compiler_ plugin is bound to the _compile_ phase
-   _compiler:testCompile_ is bound to the _test-compile_ phase
-   _surefire:test_ is bound to _test_ phase
-   _install:install_ is bound to _install_ phase
-   _jar:jar_ and _war:war_ is bound to _package_ phase

