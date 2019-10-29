# Building REST services with Spring

## Usage of REST API

### Get the list of employees

 - Using the url [http://127.0.0.1:8080/employees](http://127.0.0.1:8080/employees) with a GET request, we can access all the emplyees in the database:
![Get All Employees](https://i.imgur.com/eQC4xvV.png)

- Using the url [http://127.0.0.1:8080/employees/{id}](http://127.0.0.1:8080/employees/1) with a GET request, we can access a specific employee in the database:
![Filter Employees](https://i.imgur.com/ZVXBuXX.png))

- Using the url [http://127.0.0.1:8080/employees/](http://127.0.0.1:8080/employees) with a POST request and the correct body, we can insert a new employee to the database:
![Create New Employee](https://i.imgur.com/kHeC5ty.png))

- Using the url [http://127.0.0.1:8080/employees/{id}](http://127.0.0.1:8080/employees/3) with a PUT request and the correct body, we can update a specific employee of the database:
![Create New Employee](https://i.imgur.com/kHeC5ty.png))

- Using the url [http://127.0.0.1:8080/employees/{id}](http://127.0.0.1:8080/employees/4) with a DELETE request, we can delete an employee from the database:
![Delete Specific Employee](https://i.imgur.com/eYeCDcp.png))

### Create a layered architecture view (diagram), displaying the key abstractions in the solution, in particular: entities, repositories and REST controllers

![Layered Architecture View](https://i.imgur.com/GP7J1AZ.png)


### Describe the role of the elements modeled in the previous point.**

- The `Employee Repository` layer has the purpose to store e +provide all the information used by our system.
- The `Employee Controller` layer offers the representation and manipulation of the data trhough GET, PUT, DELETE and POST requests. 
- The `Employee` layer is used to "formalize" the data representation.

	It's used by the `Employee Repository` layer to store the data regarding Employee objects.

	It's used by the `Employee Controller` layer to create and modify information, using the `@Entity` annotation (JPA will establish a connection between the Entity and the respectiv Database Table.

### What can you do to create persistence in the Database?

One possible solution, was to decouple te database from the rest api so that when we shutdown the rest, the database continues online with all the data.

### Why is that the Employee entity does not have getters and setters defined?

The most likely reason was that the project was using Lombook (a library that includes all the getters and setters in the compiled code). However, that library doesn't come installed from default and that's why we are getting these errors.


## Accessing JPA Data with REST interface

### Command to create an instance of MySQL server 
`docker run -d -p 3306:3306 --name=mysql-server --env="MYSQL_ROOT_PASSWORD=123456" mysql`

### Commands to access MySql within docker container:
```
docker  exec  -ti  mysql-server  bash  
mysql  -u  root  -p
```

### Explain  the  annotations  `@Table`,  `@Column`,  `@Id`  found  in  the  Employee  entity.

- `@Table`: It allows to specify the details of the table that is going to be used to stored all the date in the database.
- `@Column`: is used to associate the column of the table with a specific field (we can specifiy the name of table, if it can be null, empty, etc).
- `@Id`:   is used to specify some field as the primary key.

### Explain  the  use  of  the  annotation  `@AutoWired`
If we annotate a class with `@Autowired`, Spring will automatically resolve the instance and inject it into the class that declared it. So, we don’t need to obtain the singleton instance ourselves.


# 3.3  From  data  to  presentation  (Thymeleaf)

​In this final section of the guide, I followed the following tutorial [Tutorial  Thymeleaf](https://www.vogella.com/tutorials/SpringBoot/article.html) to the 7 stage.

In sub-item (p), I used as base the work done at item 3.2 to create a MySQL Image that was able to ensure the system persistence.
​
In sub-item (q), I followed the turorial [Deploy  Spring  Boot  +  MYSQL  Application  to  Docker](https://www.javainuse.com/devOps/docker/docker-mysql), because I had some complications in the process.
