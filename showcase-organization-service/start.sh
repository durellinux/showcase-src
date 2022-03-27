./mvnw clean package -Dmaven.test.skip=true
docker build -f src/main/docker/Dockerfile.jvm -t showcase/organization-service .
deploy