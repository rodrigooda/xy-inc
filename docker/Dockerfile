FROM gradle:jdk8-alpine
LABEL maintainer="rodrigooda@outlook.com"
EXPOSE 8080
WORKDIR /tmp
COPY backend/build/libs/app-1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]