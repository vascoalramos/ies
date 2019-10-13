# Server-side programming with servlets

## Installing Apache Tomcat

1. `mkdir /opt/tomcat`
2. `cd /opt/tomcat`
3. `wget http://apache.spinellicreations.com/tomcat/tomcat-8/v8.5.32/bin/apache-tomcat-8.5.46.tar.gz`
4. `tar xvzf apache-tomcat-8.5.46.tar.gz`
5. `gedit ~/.zshrc`
6. `export CATALINA_HOME=/opt/tomcat/apache-tomcat-8.5.46`
7. Activate the modifications to the file: `. ~/.zshrc`
8. Configure the manage user in the `opt/tomcat/conf/tomcat-users.xml` (using vscode: `code tomcat-users.xml --user-data-dir`):
	```
	<role  rolename="manager-gui"/>
	<role  rolename="manager-script"/>
	<user  username="admin"  password="admin"  roles="manager-gui, manager-script"/>
	```
9. Run server: `$CATALINA_HOME/bin/startup.sh`
10. Navigate to `http://localhost:8080/manager` and when prompted for user name and password enter `admin/admin` 


## Create maven-based web application project from an external archetype

1.
	- archetypeGroupId = `org.codehaus.mojo.archetypes`
	- archetypeArtifactId = `webapp-javaee7`
	- archetypeVersion = `1.1`

		The actual project group_id and artifact_id can be whatever you may want.

2. Execute `mvn install`.
3. To deploy packed application into the application server there are 2 alternatives:
	- Use the Tomcat management interface (Tomcat manager application) to deploy a .war file [http://localhost:8080/manager](http://localhost:8080/manager).
	- The productive alternative is to use the IDE integrated deployment support. [IntelliJ configuration](https://www.mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/).


## Add a basic servlet to the project
Follow these [instructions](https://howtodoinjava.com/servlets/complete-java-servlets-tutorial/#webservlet_annotation) (from section “Develop Servlet with @WebServlet Annotation” to section “Handling Servlet Request and Response”).

#### Here's an excerpt of the server log messages in a successfull deployment:
```
12-Oct-2019 12:28:28.389 INFO [main] org.apache.catalina.core.StandardEngine.startInternal Starting Servlet Engine: Apache Tomcat/8.5.46
12-Oct-2019 12:28:28.428 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8081"]
12-Oct-2019 12:28:28.476 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["ajp-nio-8009"]
12-Oct-2019 12:28:28.493 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in 173 ms
Connected to server
[2019-10-12 12:28:28,564] Artifact ies21:war exploded: Artifact is being deployed, please wait...
[2019-10-12 12:28:29,161] Artifact ies21:war exploded: Artifact is deployed successfully
[2019-10-12 12:28:29,161] Artifact ies21:war exploded: Deploy took 597 milliseconds
12-Oct-2019 12:28:38.433 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [/opt/tomcat/apache-tomcat-8.5.46/webapps/manager]
12-Oct-2019 12:28:38.551 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/opt/tomcat/apache-tomcat-8.5.46/webapps/manager] has finished in [117] ms
```

#### What are the responsibilities/services of a “servlet container”?

**1. What is a Java Servlet?**
> The basic idea of Servlet container is using Java to dynamically generate the web page on the server side. So servlet container is essentially a part of a web server that interacts with the servlets.
> 
> -- <cite>[What is a Servlet Container?](https://dzone.com/articles/what-servlet-container)</cite>

**2. How Servlet container and web server process a request?**
-   Web server receives HTTP request.
-   Web server forwards the request to servlet container.
-   The servlet is dynamically retrieved and loaded into the address space of the container, if it is not in the container.
-   The container invokes the `init()` method of the servlet for initialization(invoked once when the servlet is loaded first time).
-   The container invokes the `service()` method of the servlet to process the HTTP request, i.e., read data in the request and formulate a response.

	The servlet remains in the container’s address space and can process other HTTP requests.
-   Web server return the dynamically generated results to the correct location.


## Deploy your web app (Tomcat) in a docker container
1.  `docker image pull tomcat:8.0`
2. `docker container create --publish 8082:8080 --name my-tomcat-container tomcat:8.0`
3. `docker container start my-tomcat-container`
4. Create a file with name `Dockerfile` in **_root directory of your_** application without any extension and add following lines in it.
	```
	# we are extending everything from tomcat:8.0 image ...  
	FROM tomcat:8.0
	MAINTAINER your_name
	
	# COPY _path-to-your-application-war_ _path-to-webapps-in-docker-tomcat
	COPY some-app/target/some-app.war /usr/local/tomcat/webapps/
	```
5. `docker image build -t your_name/some-app-image ./`
6. `docker container run -it --publish 8081:8080 your_name/some-app-image`

Your application can be accessed in _**http://localhost:8081**_.


## Authors

-   **Vasco Ramos (nmec 88931)** - [vascoalramos](https://github.com/vascoalramos)
