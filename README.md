# Microservice

Customers

## Getting Started

These instructions will get you a copy of the project up and running on your
local machine for development and testing purposes. See deployment for notes on
how to deploy the project on a live system.

- Environment variable "SPRING_PROFILES_ACTIVE" (dev/qa/prd)

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

### Documentation

```
mvn compile depgraph:graph depgraph:aggregate # Modules dependency graph
```

### Generate container mysql
```
docker run -p 3306:3306 --name fcdb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=fcdb -d mysql:5.5
```

## Generate JKS Java KeyStore File

```
keytool -genkeypair -alias mytest 
                    -keyalg RSA 
                    -keypass mypass 
                    -keystore mytest.jks 
                    -storepass mypass
```

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the tags on this repository.

## License

Copyright @Yurmont All Rights Reserved - Proprietary and confidential
