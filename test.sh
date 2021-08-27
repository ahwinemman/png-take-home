function runTests() {
echo "Starting pub-sub demo application  ..\n"
printf "=> http://172.25.0.90:9000/v1/topic1 to topic1... \n response: "
curl -X POST -H "Content-Type: application/json" -d '{ "url": "http://172.25.0.90:9000/v1/topic1"}' http://localhost:8080/v1/subscribe/topic1

printf "\n => http://172.25.0.90:9000/v1/topic2 to topic2....\n response: "
curl -X POST -H "Content-Type: application/json" -d '{ "url": "http://172.25.0.90:9000/v1/topic2"}' http://localhost:8080/v1/subscribe/topic2

printf '\n => Publishing data {"data": "{message: hello}"} to topic1\n response:'
curl -X POST -H "Content-Type: application/json" -d '{"data": "{message: hello}"}' http://localhost:8080/v1/publish/topic1
printf "\n"
}

runTests