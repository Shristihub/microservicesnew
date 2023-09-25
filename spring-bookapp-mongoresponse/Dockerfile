FROM openjdk:17-alpine
EXPOSE 8081
COPY target/bookresponse.jar book-response.jar
ENTRYPOINT [ "java","-jar","book-response.jar" ]