FROM openjdk:17-alpine
EXPOSE 8081
COPY target/book.jar book-kafka.jar
ENTRYPOINT [ "java","-jar","book-kafka.jar" ]