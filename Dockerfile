FROM maven:3.8.3-openjdk-17

#WORKDIR /app
#ADD pom.xml /app
#RUN #mvn verify clean --fail-never
#
#COPY . /app
#RUN mvn package install -DskipTests
#COPY target/marketing-*.jar /marketing.jar
##ADD ./target/marketing-0.0.1.jar marketing.jar
#ENTRYPOINT ["java", "-jar", "marketing.jar"]

WORKDIR /app

COPY target/marketing-0.0.1-SNAPSHOT.jar /app/marketing.jar

ENTRYPOINT ["java", "-jar", "marketing.jar"]
