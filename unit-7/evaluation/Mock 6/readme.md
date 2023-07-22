Blogger Hub

REST API for an Online Blogging Platform that allows bloggers to perform CRUD operations. 
The application also includes user and admin validation and authentication.


## ![TECH_STACK](https://img.shields.io/badge/Tech_Stack-%231572B6.svg?style=for-the-badge)

- JAVA
- SPRING
- SPRINGBOOT
- HIBERNATE
- MAVEN
- MYSQL
- HTML
- CSS
- JAVASCRIPT

## ![TECH_STACK](https://img.shields.io/badge/Dependencies-%231572B6.svg?style=for-the-badge)

- SPRING DATA JPA
- SPRING BOOT DEVTOOLS
- SPRING WEB
- HIBERNATE
- MYSQL DRIVER
- VALIDATION
- LOMBOK
- SPRING SECURITY

## ![TECH_STACK](https://img.shields.io/badge/Setting_&_Installation-%231572B6.svg?style=for-the-badge)

Install the Spring Tools Suite 
```bash
https://spring.io/tools
```

Install MySQL Community Server

```bash
https://dev.mysql.com/downloads/mysql/
```

Clone the Repository

```bash
git clone https://github.com/masai-course/aman_chaudhary_fw22_0540
```

Go to Unit 7 -> evaluation  -> Mock 6

Open MySQL Server
```bash
Create a New Database in SQL: "blog" 
```
## Run Locally


Go to the Project Directory

```bas
Open the BlogApp Folder with S.T.S
```

Go to **src/main/resources > application.properties** & change your username and password (MySQL server username & password)

```bash
spring.datasource.username="username"
spring.datasource.password="password"
```

To change the **Server Port**

```bash
server.port=8888
```

Go to **com.blog package > BlogAppApplication.java**

```bash
Run as Spring Boot App
```
Open the following URL for Swagger-UI 
```bash
http://localhost:8888/swagger-ui/
```