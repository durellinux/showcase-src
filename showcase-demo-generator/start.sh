pushd DemoGenerator/DemoGenerator || return 1
dotnet restore
dotnet build
dotnet publish -c Release -o ./dist/docker

deploy
popd || return 1
