# RoverServices

I completed below api and test case written for environment controller:
 
POST /api/environment/configure
PATCH /api/environment

POST /api/rover/configure
GET /api/rover/status

POST /api/rover/move (not completed fully)


Just run inside my repo

mvn clean install

then run springboot application with application.yml file

run application using
/RoverServices/tools/compile.bat
/RoverServices/tools/run.bat

or 

java -jar  target/rover-test-0.0.1-SNAPSHOT.jar


swagger url:

http://localhost:8080/roverservices/swagger-ui.html#/


you will find below apis inside swagger:

POST /api/environment/configure
PATCH /api/environment

POST /api/rover/configure
GET /api/rover/status

POST /api/rover/move