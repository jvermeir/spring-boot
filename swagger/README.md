# Spring boot swagger api

## Build

```bash
mvn clean install
```

## Run

```bash
mvn clean package
java -jar target/swagger-0.0.1-SNAPSHOT.jar
```

## Examples
```bash
curl http://localhost:9090/stuff/all
```
    
## Swagger ui in a browser

    http://localhost:9191/swagger-ui.html#/