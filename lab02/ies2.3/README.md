# Introduction to web apps with Spring Boot

## Demo app using Spring Boot io
Using [Spring Initializr](https://start.spring.io/) and adding the “Spring web” dependency, we get a demo zip with all the content of the web app.

After we unzip the file, execute these commands:
1. `mvn package`
2. `java -jar target/demo-0.0.1-SNAPSHOT.jar`

After this, we acces the page _[localhost:8080](http://localhost:8080/)_ and get the following output:
```
# Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sat Oct 12 22:18:23 WEST 2019

There was an unexpected error (type=Not Found, status=404).

No message available
```
