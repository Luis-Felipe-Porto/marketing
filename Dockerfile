FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/marketing-0.0.1-SNAPSHOT.jar /app/marketing.jar

ENTRYPOINT exec java -jar marketing.jar
