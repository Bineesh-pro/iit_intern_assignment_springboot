FROM openjdk:21
COPY /target/iit_intern_assignment-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]