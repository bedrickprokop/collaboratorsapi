#collaboratorsapi

Web API that handle requests from collaborators app and manage the persistence of the data


#Clone the repository
git clone https://github.com/bedrickprokop/collaboratorsapi.git

and navigate to 'collaboratorsapi' folder

cd collaboratorsapi

#Run unit tests
mvn test

#Run integration tests + unit tests
mvn verify

#Run application
mvn spring-boot:run

#Acess local database
Open your browser and type: localhost:8080/console

Saved Settings: Generic H2 (Embedded)

Settings Name: Generic H2 (Embedded)

Driver Class: org.h2.Driver

JDBC URL: jdbc:h2:file:~/h2/collaborators_db;DB_CLOSE_ON_EXIT=FALSE

User Name: root

Password: root