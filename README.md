# Spring Shop

![Banner](/banner.png)

![BadgeSpring](https://img.shields.io/badge/Framework-Spring-brightgreen) 
![BadgeWork](https://img.shields.io/badge/Work-In%20Progress-yellow)

Creating a full online store using Spring, JSPs and MySQL

## Project requirements
- JDK 8
- Maven 3.x
- Tomcat 8.5+

## Project setup

Make sure to modify the ```application.properties``` config file in order to change database pointers.
Once you have configured the database, you can use ```dump.sql``` to retrieve initial data.

Run:
```
mvn clean package
```

Then move the generated WAR file in the webapp folder of your instance of tomcat.

