# Spring shell example

## Build

```bash
mvn clean install
```

## Run

```bash
mvn clean package
java -jar target/shell-0.0.1-SNAPSHOT.jar
```

## Examples

Because the echo method has a ... you can call it like this:

    my-shell:>echo stuff hallo

instead of the default 

    my-shell:>echo-default --stuff hallo
        
