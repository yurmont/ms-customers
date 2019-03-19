# Customers Microservice

## Getting Started

* These instructions will get you a copy of the project up and running on your
local machine for development and testing purposes. 
* Controllers, services and repositories have unit tests with 90% of test coverage.
* The service was deployed to Amazon AWS and Azure.
** http://customers-microservice.us-east-2.elasticbeanstalk.com/swagger-ui.html#/
** https://customers-microservice.azurewebsites.net/swagger-ui.html#/

## Prerequisites

To build backend you will need:

* Java SDK 1.8.162 or higher
* Maven 3.x or higher
* Docker 17.12.x or higher
* Docker Compose: 1.18.x or higher

## Testings

### Unit Testing

```
mvn test
```

### Integration Testing & Automated Code Validation

```
mvn verify
```

## Building

### Executable Jar

```
mvn clean verify
```

### Container

```
mvn clean verify
docker-compose -f *-app/src/main/docker/docker-compose.yml build
```

## Running

### Jar

```
java -jar *-app/target/customs-app-*-SNAPSHOT.jar
```

### Container

```
docker-compose -f */src/main/docker/docker-compose.yml up
```

### Deployment

```
mvn azure-webapp:deploy
```

## License

Copyright @Yurmont All Rights Reserved - Proprietary and confidential
