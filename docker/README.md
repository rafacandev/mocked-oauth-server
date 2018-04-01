Docker Image for Match and Trade Web API
========================================

Building a New Image
--------------------
When a new `mocked-oauth-server` version is released we need to update
the docker image to reflect the newly released version.

```
# Build 'mocked-oauth-server'
mvn clean package

# Copy the executable jar file to 'docker/mocked-oauth-server.jar'
cp target/mocked-oauth-server-0.0.1-SNAPSHOT.jar docker/mocked-oauth-server.jar

# Build the docker image with a new tag
sudo docker build -t rafaelsantosbra/mocked-oauth-server:0.0-SNAPSHOT docker/

# Start the docker image: `docker-compose up`
sudo docker-compose --file docker/docker-compose.yml up

# Verify if the application started correctly.
curl "http://localhost:8081/oauth/sign-in?redirect_uri=test&state=test"

# Sign-in to dockerhub
sudo docker login

# Push the new tag.
sudo docker push mocked-oauth-server:0.0-SNAPSHOT

```
