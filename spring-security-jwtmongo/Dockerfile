FROM openjdk:17-alpine
EXPOSE 8081
COPY target/security-jwt-client.jar jwt-mongo.jar
ENTRYPOINT [ "java","-jar","jwt-mongo.jar" ]