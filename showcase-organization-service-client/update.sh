curl http://localhost/organizationsservice/swagger.json > swagger.json

# Cleaning csharp
rm -rf csharp

# Generating csharp
openapi-generator-cli generate -i swagger.json -g csharp-netcore --additional-properties=nullableReferenceTypes=true,packageName=ShowcaseOrganizationServiceClient,targetFramework=net6.0,validatable=false -o ./csharp
rm csharp/git_push.sh

# Pushing csharp
pushd csharp || return 1
dotnet pack
nuget push ./src/ShowcaseOrganizationServiceClient/bin/Debug/ShowcaseOrganizationServiceClient.1.0.0.nupkg -Source Artifactory
popd || return 1