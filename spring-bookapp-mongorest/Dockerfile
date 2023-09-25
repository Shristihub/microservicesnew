FROM openjdk:17-alpine
EXPOSE 8081
COPY target/bookapp-mongo.jar book-mongo.jar
ENTRYPOINT [ "java","-jar","book-mongo.jar" ]