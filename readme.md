# Spring boot training

# Learning

## Part 1

- How to create a Spring project using Spring Initializr site (https://start.spring.io/);
- How to import and execute it in Intellij throught main method;
- Created a Controller class using `@RestController` and mapping an url with `@RequestMapping`;
- How to use the `@RequestBody` annotation to receive data from body request as parameter in a Controller;
- How to use the DTO (Data Transfer Object) pattern, with Java Records, to represent received data from Post request;
- How to map a JPA entity and to create an Repository interface for it (...extends JpaRepository<Medico, Long>);
- How to use Flyway as Migration tool management in the project;
- How to do validations with Bean Validation and its annotations (@NotBlank, @Email, @Pattern, etc.);
- How to use the Pageable interface from Spring to get data with pagination;
- How to control the pagination and sort of data returned from API with de queryParams `page`, `size` and `sort`.
- How to set the application properties to show and format SQL in console;
- How to map requests using the follow annotations `@GetMapping`, `@PutMapping`, `@PostMapping`, `@DeleteMapping`;
- How to implement the concept of logic to delete using a boolean attribute;
- How to use `ResponseEntity` to customize the Controller responses, modifying HTTP code and adding info in Headers when is necessary;
- How to create a class to handle with excpetions using `@RestControlleAdvice`;
- How to use the `@ExceptionHandler` to indicate what exception a specific method from `@RestControllerAdvice` should catch;
- How to handle exceptions 404 (Not Found - EntityNotFoundException.class) and 400 (Bad Request - MethodArgumentNotValidException.class) for errors launched by Bean Validation;
- How to customize the JSON returned by API em case of Bean Validation errors;
- How to work with Spring Security, implementing it and changing the default settings (Statefull) to work with a Rest api (Stateless);
- Work with Auth0 java-jwt library to generate tokens;
- How to work with environment variables in `application.properties` file together the `@Value` annotation in a class managed by Spring;
- How to implement filters creating a class that extends `OncePerRequestFilter` from Spring;
- How to use the Auth0 java-jwt library to validate tokens jwt;
- Development of authentication process using the `SecurityContextHolder` class from Spring;
- How intercept request according URL and method HTTP.

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vitorgonzaga/)

## Demo

Insert gif or link to demo

## Deployment

To deploy this project run

```bash
  npm run deploy
```

