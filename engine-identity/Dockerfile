FROM openjdk:21-jdk
## Add the wait script to the image
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait
ARG JAR_FILE=build/libs/engine-identity-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENV MALLOC_ARENA_MAX: "2"
ENTRYPOINT ./wait && exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
