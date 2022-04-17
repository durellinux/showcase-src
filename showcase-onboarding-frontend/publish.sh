gitsha=$(git rev-parse --short HEAD)
docker tag showcase/onboarding-frontend durellinux.jfrog.io/default-docker-local/showcase-onboarding-frontend:gitsha
docker push durellinux.jfrog.io/default-docker-local/showcase-onboarding-frontend:gitsha