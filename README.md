REQUEST:
Create an API that acts as a ""Hub Products Management"" tool
- Create a Github profile if you don't have one
- Use git in a verbose manner, push even if you wrote only one class
- Create a Java, maven-based project, Springboot for the web part
- No front-end, you can focus on backend, no need to overcomplicate the structure
- Implement basic functions, for example:
  add-product,
  find-product,
  change-price or others
- Highly-recommended:
  Implement a basic authentication mechanism and role-based endpoint access
- Design error mechanism and handling
- Logging
- Write unit tests, at least for one class
- Use Java 17+ features
- Add a small Readme to document the project


Implementation:
Used Jpa communicate with database, using Hibernate implementation than defined entities and repositories.
Methods are exposed in a service for users and products entities. 
For product entity there are a database relation only for example but it should be empty
In exception package are custom exception used in service classes.
There are also required DTOs and mappers in different packages. 
In controller classes the endpoints are exposed.
Unit test for user functionality using Junit5 and Mockito.