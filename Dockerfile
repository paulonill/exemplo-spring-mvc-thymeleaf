FROM openjdk:8-jdk-alpine

ADD target/*.jar app.jar

ARG JAVA_OPTS=""
ENV JAVA_OPTS=$JAVA_OPTS
ARG SPRING_PROFILES_ACTIVE="dev"

ENTRYPOINT exec java $JAVA_OPTS \
 -Djava.security.egd=file:/dev/./urandom \
 -Duser.timezone=Brazil/East \
 -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE \
 -jar app.jar
