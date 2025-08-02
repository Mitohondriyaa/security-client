FROM openjdk:21
WORKDIR /app
COPY target/security-client-0.0.1-SNAPSHOT.jar security-client.jar
ENTRYPOINT ["java", "-jar", "security-client.jar"]