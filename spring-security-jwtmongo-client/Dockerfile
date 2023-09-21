FROM openjdk:17-alpine
EXPOSE 8081
COPY target/security-jwt-client1.jar jwt-client.jar
ENTRYPOINT [ "java","-jar","jwt-client.jar" ]