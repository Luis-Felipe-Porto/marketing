FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /app
COPY pom.xml /app/pom.xml
RUN mvn dependency:go-offline -B
COPY ./src /app/src
#COPY application.yml /app/src/main/resources/application.yml
RUN mvn clean package -DskipTests


FROM openjdk:17-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/marketing.jar

CMD ["java", "-jar", "marketing.jar"]
