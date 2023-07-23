# JobsToWorkers

JobsToWorkers is a Spring Boot application that I've developed to tackle the challenge of matching jobs to workers using a REST API.

## Description

As part of Swipejobs, my aim was to efficiently match jobs to workers. Therefore, I developed JobsToWorkers, a matching engine. This application retrieves available workers and jobs data through the REST APIs - `/workers` and `/jobs` respectively.

I designed a unique REST API - `matches` that accepts a `workerId` and returns no more than three appropriate jobs for that worker.

The technologies I've employed in this project include:

- Spring Boot Starter Web for crafting RESTful web services
- Spring Boot Starter Actuator to add production-ready features
- Springdoc Openapi Starter Webmvc UI for seamless API documentation
- Lombok to cut down boilerplate code

While developing, I prioritized the quality of job-worker matches and maintained high readability in my code.

## Prerequisites

To run this project, you need:

- JDK 17
- Maven 3.6.x or later
- An IDE of your choice (e.g. IntelliJ, Eclipse)

## Getting Started

1. Clone the repository:
   ```
   git clone https://github.com/<username>/JobsToWorkers.git
   ```

2. Navigate to the project directory:
   ```
   cd jobs-to-workers
   ```

3. Build the project:
   ```
   mvn clean install
   ```

4. Run the Spring Boot application:
   ```
   mvn spring-boot:run
   ```

5. You can now test the application via Swagger UI at the following link: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Actuator
- Springdoc Openapi Starter Webmvc UI
- Lombok
- Spring Boot Starter Test (for testing purposes)

## Build

The build process uses the Spring Boot Maven plugin with a specific configuration that excludes Lombok from the final artifact, as it's only necessary during compile-time.

## Contributing

If you wish to contribute, please fork the repository, make your changes, and create a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.