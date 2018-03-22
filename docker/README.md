Docker Image for Match and Trade Web API
========================================

Building a New Image
--------------------
When a new `mocked-oauth-server` version is released we need to update
the docker image to reflect the newly released version.

1. Build `mocked-oauth-server`
2. Copy the executable jar file to `docker/mocked-oauth-server.jar`
Example: `mocked-oauth-server $ cp target/mocked-oauth-server-0.0.1-SNAPSHOT.jar docker/mocked-oauth-server.jar`
3. Build the docker image with a new tag
Example: `sudo docker build -t rafaelsantosbra/mocked-oauth-server:v0.1 .`
4. Start the docker image: `docker-compose up`
5. Verify if the application started correctly.
Example: `curl "http://localhost:8081/sign-in?redirect_uri=test&state=test"`
6. Sign-in to dockerhub: `sudo docker login`
7. Push the new tag.
Example: `sudo docker push rafaelsantosbra/mocked-oauth-server:v0.1`
