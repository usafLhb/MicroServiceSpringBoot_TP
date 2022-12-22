FROM openjdk:11
COPY target/dockerjava.jar dockerjava.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","dockerjava.jar"]