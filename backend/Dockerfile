#
# BUILD STAGE
#
FROM maven:3.8-jdk-8-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

#
# PACKAGE STAGE
#
FROM openjdk:8-jre-alpine
COPY --from=build /usr/src/app/target/javalin-chatbot-1.0-jar-with-dependencies.jar /usr/app/javalin-chatbot-1.0-jar-with-dependencies.jar
EXPOSE 7070
RUN apk add --no-cache tzdata
ENV TZ=Europe/Prague
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN date
CMD ["java","-jar","/usr/app/javalin-chatbot-1.0-jar-with-dependencies.jar"]
