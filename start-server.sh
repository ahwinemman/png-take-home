function run() {
    docker-compose up --force-recreate
}

if [ -z $@ ]; then
    run
fi

$@