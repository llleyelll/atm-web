FROM openjdk:8-jdk-alpine
EXPOSE 8090
ARG JAR_FILE=target/atm-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]