# Takeaways
## Run MySQL
```shell
> docker pull mariadb
> docker run --name sbur-mysql \
    -e MYSQL_ROOT_PASSWORD=... \
    -e MYSQL_USER=finder \
    -e MYSQL_PASSWORD=... \
    -e MYSQL_DATABASE=finder \
    -p 3306:3306 \
    -d mariadb
```
## Generate initial tables
```properties
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create
```
## Printing Aircraft objects
We can use lombok:
```java
@ToString
class Aircraft {}
```
## Watching for data
```shell
mysql -u ... -p... finder
> SHOW FULL TABLES;
> SELECT * FROM aircraft;
```
