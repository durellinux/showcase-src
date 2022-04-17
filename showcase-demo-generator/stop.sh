pushd DemoGenerator/DemoGenerator || return 1
docker-compose down $1
popd || return 1
