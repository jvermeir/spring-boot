# Spring boot rest app

## Build

```bash
mvn clean install
```

## Run

```bash
mvn clean package
java -jar target/rest-0.0.1-SNAPSHOT.jar
```

## MySql container

    mkdir ./data
    docker run --name some-mysql -v $PWD/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql:latest
    
Download a sql client, MySqlWorkbench is probably easiest

Create the database and an account:

```bash
create database db_example;
create user 'springuser'@'%' identified by 'ThePassword';
grant all on db_example.* to 'springuser'@'%'; 
```    

## Examples
```bash
curl -X POST http://localhost:9090/stuff -H "Content-Type: application/json" --data '{"id":3,"description":"id3desc"}' 
curl http://localhost:9090/stuff/all
```
    
## Commandline test script
```bash
curl -X DELETE http://localhost:9090/stuff
curl -X POST http://localhost:9090/stuff -H "Content-Type: application/json" --data '{"id":1,"description":"id1desc"}' 
curl -X POST http://localhost:9090/stuff -H "Content-Type: application/json" --data '{"id":2,"description":"id2desc"}' 
curl -X POST http://localhost:9090/stuff -H "Content-Type: application/json" --data '{"id":3,"description":"id3desc"}' 
curl http://localhost:9090/stuff/all
```

## Java client
     
see `com.example.rest.Client`

# TODO

Make sure HTTP status is correct when something fails (exception) or a key is not found. 