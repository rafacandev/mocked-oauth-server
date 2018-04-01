FROM openjdk:alpine
VOLUME /tmp
ADD mocked-oauth-server.jar /mocked-oauth-server/mocked-oauth-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mocked-oauth-server/mocked-oauth-server.jar","-Xmx10m","-XX:MaxPermSize=10m"]
