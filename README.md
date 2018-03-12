# mocked-oauth-server
An oauth server for testing purposes

# Quick Start

```
git clone https://github.com/rafasantos/mocked-oauth-server.git
cd mocked-oauth-server
mvn spring-boot:run
firefox "http://localhost:8081/sign-in?redirect_uri=http://localhost:8080/authenticate/callback&state=1234"
```

## Valid usernames

* alice
* bob
* carol
* dylan
* elton

_Any password is valid as long as the username is correct_
