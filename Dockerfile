FROM openjdk:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} hackathon.jar
ENTRYPOINT ["java","-jar","/hackathon.jar"]