FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/modulo-endereco-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} modulo-endereco-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/modulo-endereco-0.0.1-SNAPSHOT.jar"]
