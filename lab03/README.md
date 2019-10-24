# Building REST services with Spring

## Usage of REST API

### Get the list of employees

 - Using the url [http://127.0.0.1:8080/employees](http://127.0.0.1:8080/employees) with a GET request, we can access all the emplyees in the database:
![Get All Employees](https://i.imgur.com/eQC4xvV.png)

- Using the url [http://127.0.0.1:8080/employees/{id}](http://127.0.0.1:8080/employees/1) with a GET request, we can access a specific employee in the database:
![Filter Employees](https://i.imgur.com/ZVXBuXX.png)

- Using the url [http://127.0.0.1:8080/employees/](http://127.0.0.1:8080/employees) with a POST request and the correct body, we can insert a new employee to the database:
![Create New Employee](https://i.imgur.com/kHeC5ty.png)

- Using the url [http://127.0.0.1:8080/employees/{id}](http://127.0.0.1:8080/employees/3) with a PUT request and the correct body, we can update a specific employee of the database:
![Create New Employee](https://i.imgur.com/kHeC5ty.png)

- Using the url [http://127.0.0.1:8080/employees/{id}](http://127.0.0.1:8080/employees/4) with a DELETE request, we can delete an employee from the database:
![Delete Specific Employee](https://i.imgur.com/eYeCDcp.png)

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
