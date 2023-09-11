#FROM ubuntu:latest
FROM openjdk:11
LABEL authors="user"
VOLUME /tmp
EXPOSE 8090
ARG JAR_FILE=target/spring-boot-docker.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT ["top", "-b"]
