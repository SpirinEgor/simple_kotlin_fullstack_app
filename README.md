# Simple kotlin fullstack application

Example of Client-Server application written on pure Kotlin.

## Server

Server is an example of RestAPI developed with [Ktor](https://ktor.io).
It has only two endpoints defined in
[`server/src/.../Routing.kt`](server/src/main/kotlin/com/example/plugins/Routing.kt).

To run local use:
```shell
./gradlew installDist
export PORT=8080
./server/build/install/server/bin/server
```

Repository also provide continuous deployment to [Heroku](https://heroku.com) (see [`Procfile`](Procfile)).

## Client

Client is a web application written in [`Kotlin/JS`](https://kotlinlang.org/docs/js-get-started.html).
It provides simple HTML form with an input and submit button.
Each submit sends POST request to server and shows its response.

At first, setup server url in [`client/src/.../Api.kt`](client/src/main/kotlin/Api.kt)

To run local use:
```shell
./gradlew runBrowser
```
Client would start on [localhost:80](http://localhost/).

Also, client provides docker-based usage:
```shell
# 1. Build web application
./gradlew browserProductionWebpack
# 2. Build docker (copy sources into NGINX home directory)
docker build -t my-client-application .
# 3. Start docker in daemon mode
docker run -it -d --rm -p 80:80 --name daemon-client my-client-application

# To stop client
docker stop daemon-client
```
