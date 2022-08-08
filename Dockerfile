FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backend.jar
CMD ["java","-jar","/backend.jar"]


