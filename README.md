# Pub-Sub Service
This project is build with the Spring Boot Framework

## Getting Started:

$ chmod +x start-server.sh

$ ./start-server.sh

## Run the curl commands to test
$ chmod +x test.sh

$ ./test.sh

## Postman collection folder
$ /postman/

## External/Internal endpoints
$ pub-server : localhost:8080 / 172.25.0.80:8080

$ sub-server : localhost:9000 / 172.25.0.90:9000

## Database
- In-memory / Embedded database (H2) is used in the pub-server to store subscriptions
