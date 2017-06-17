# Upload File

This project provide API to upload file, store file in file system and support search file Metadata by File Name or Size

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them


### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

1. Java JDK 1.8
2. Maven 3.3.9
3. Postgresql 9.4 (https://www.postgresql.org/download/) 
    Recommend password off postgresql is "postgres"

Verify:
open terminal/Cmd and Type
1. java -version => should display JDK 1.8
2. mvn -version=> should display Maven details

## Project Structure

> Folder structure

### Directory structure

    .
    ├── db                      # database script to create table (Flyway structure)
    ├── src                     # Source files
    ├── pom.xml                 # Maven file
    └── README.md
    
### Java file structure ./src/main

    .
    ├── java
    |     |--com.uploadfile
    |               |--configuration                #Spring, Database, Swagger Configuration
    |               |--domain                       #Domain object for Uploaded Filed
    |                |--repository                  #Spring Data Jpa Repository, handle access database
    |                |--resource                    #All Enpoint (API)
    |                |--service                     #Define all service, connect API to repository
    |                |--UploadFileApplication.java  #Java main function, Spring boot start from here
    ├── resources
            |-appication.properties                 #store all properties configuration for project
    

### Setup

Database setup:

1. open pgAdmin (postgresql): create database name "upload_file"
2. if username and password of database is not "postgres", open pom.xml and edit user, password
3. go to project directory and run:
```
mvn flyway:migrate -N
```
It will automatically create table in "upload_file" database

### Run app
1. edit dbuser and db password in application.properties
2. edit spring.uploadfile.path (full path to folder stored uploaded file)
2. Run main() in UploadFileApplication.java
### Tests
Open (http://localhost:8080/swagger-ui.html) to see all API and Try it out

### Package (If need to deploy outside source code)
1. Run mvn build:
```
mvn clean package
```
2. Copy ./target/uploadfile-0.0.1-SNAPSHOT.jar to place where need to deploy
3. run:
```
java -jar uploadfile-0.0.1-SNAPSHOT.jar
```
### APIs
1. (http://localhost:8080/file/upload)      #API to upload file
2. (http://localhost:8080/file/find)        #API to find metadata by fileName and size
3. (http://localhost:8080/file/findAll)     #API to get all metadata files
## API doc
(http://localhost:8080/swagger-ui.html)

