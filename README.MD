# South African Mobile Numbers Validator #

java 1.8 + Spring boot 2 + JPA + mysql



## **Installation** ##

build and test the project

```bash
cd /path/to/demo
mvn clean package
```


and create the MySql database :

```sql
create database demo;
create user 'demo'@'%' identified by 'demo';
grant all on demo.* to 'demo'@'%';
use demo;

DROP TABLE IF EXISTS PHONE_NUMBER;
  
CREATE TABLE PHONE_NUMBER (
  ID INT  PRIMARY KEY,
  PHONE_NUMBER VARCHAR(50) NOT NULL,
  STATUS INT DEFAULT NULL,
  NOTE VARCHAR(1000) DEFAULT NULL
);

```

 
## **Run demo-cli in order to populate the database with data :** ##
```bash
cd demo-cli/target
java -jar demo-cli-1.0-SNAPSHOT-spring-boot.jar --filepath="/path/to/South_African_Mobile_Numbers.csv" 
```
NB: the first 2 rows of the file will be treated as headers


## **Run the embedded Tomcat server :** ##
```bash
cd demo-web/target
java -jar demo-web-1.0-SNAPSHOT-spring-boot.jar
```

The following REST services are exposed :

- GET http://localhost:8080/demo/numbers : return all the numbers in the database
- GET http://localhost:8080/demo/numbers/status/{status} : return all the numbers in the database in the provided status.

	- Status are :
		- 0 : invalid numbers
		- 1 : valid numbers
		- 2 : modified numbers
	
	a note will be provided describing the operation attempted to validate the number (just adding the correct prefix for now) 
