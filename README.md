# CollaboratorsAPI

Web API that handle requests from collaborators app and manage the logical and persistence of the data

### Requirements

- Java 7/8
- Maven
- An IDE for development if you want edit the code in a easier way like IntellIj, Eclipse, Netbeans, etc

### Setup and statup

- $ git clone https://github.com/bedrickprokop/collaboratorsapi.git

- $ cd collaboratorsapi

- $ mvn spring-boot:run

### Accessing the embedded database

Open your browser and type: localhost:8080/console

- Saved Settings: Generic H2 (Embedded)
- Settings Name: Generic H2 (Embedded)
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:file:~/h2/collaborators_db;DB_CLOSE_ON_EXIT=FALSE
- User Name: root
- Password: root

### Acessing the Restful API

##### Collaborator

- Create: POST to localhost:8080/api/collaborator with the following JSON example: 

    {"name":"Bedrick", "login":"myPersonalLogin", "password":"myPassword", "profile":"ADMINISTRATOR"}
    
    All attributes are required except "password", and they follow the rules below:
    * Name length should be between 3 to 20 characters;
    * Login length should be between 5 to 20 characters;
    * Password length should be between 5 to 15 characters;
    * Profile must be ADMINISTRATOR or COLLABORATOR or "0" or "1" or 0 or 1.

- FindAll: GET to localhost:8080/api/collaborator

- FindOne: GET to localhost:8080/api/collaborator/ID where "ID" is the collaborator identifier

- Update: PUT to localhost:8080/api/collaborator with the following JSON example:

    {"id":1, "name":"Bedrick", "login":"myPersonalLogin", "password":"myPassword", "profile":"COLLABORATOR"}
    
    All attributes are required except "password", and they follow the rules below:
    * Name length should be between 3 to 20 characters;
    * Login length should be between 5 to 20 characters;
    * Password length should be between 5 to 15 characters;
    * Profile must be ADMINISTRATOR or COLLABORATOR or "0" or "1" or 0 or 1.

- Delete: DELETE to localhost:8080/api/collaborator/ID where "ID" is the collaborator identifier