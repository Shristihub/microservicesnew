FROM openjdk:17-alpine
EXPOSE 8081
COPY target/jwtclient.jar jwt-client.jar
ENTRYPOINT [ "java","-jar","jwt-client.jar" ]