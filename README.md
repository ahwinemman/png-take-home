# make executable
$ chmod +x start-server.sh

# start 
$ ./start-server.sh

# run curl commands
$ chmod +x test.sh

$ ./test.sh

# Postman collection folder
$ /postman/

# External/Internal endpoints
$ pub-server : localhost:8080 / 172.25.0.80:8080
$ sub-server : localhost:9000 / 172.25.0.90:9000

# Database
- In-memory database (H2) is used for easy setup
