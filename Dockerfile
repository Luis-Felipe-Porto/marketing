FROM maven:3.8.3-openjdk-17

WORKDIR /app
COPY . /app
ADD pom.xml /app-

RUN mvn clean package -DskipTests
COPY target/marketing-0.0.1-SNAPSHOT.jar /app/marketing.jar

ENTRYPOINT ["java", "-jar", "marketing.jar"]
