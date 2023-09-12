FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
#COPY . .
RUN mvn spring-boot:run

EXPOSE 8090
#LABEL authors="user"
#VOLUME /tmp
#ARG JAR_FILE=target/spring-boot-docker.jar
#ADD ${JAR_FILE} app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
#ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT ["top", "-b"]
