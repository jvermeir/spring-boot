# Spring boot security

## Build

```bash
mvn clean install
```

## Run

```bash
mvn clean package
java -jar target/security-0.0.1-SNAPSHOT.jar
```

## Examples

```bash
curl -v  -L http://localhost:9292/login -d "username=me&password=password" 2> err.txt
cat err.txt|grep JSESSIONID | awk -F' ' '{print $3}' | sed 's/;//' | awk -F'=' '{print $2}'
curl -v -L http://localhost:9292/stuff/all -b JSESSIONID=$JSESSIONID
```    