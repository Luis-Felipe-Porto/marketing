FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /app
COPY pom.xml /app/pom.xml
RUN mvn dependency:go-offline -B
COPY ./src /app/src
RUN mvn clean package -DskipTests


FROM openjdk:17-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/marketing.jar

ENTRYPOINT ["java", "-jar", "marketing.jar"]


#FROM openjdk:17-alpine
#
#WORKDIR /app
#
#COPY ./target/marketing-0.0.1-SNAPSHOT.jar /app/marketing.jar
#
#ENTRYPOINT exec java -jar marketing.jar
