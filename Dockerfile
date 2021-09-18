FROM openjdk:8-jdk-alpine
MAINTAINER paulo_berranteiro
COPY target/exemplo-spring-boot-thymeleaf.jar exemplo-spring-boot-thymeleaf.jar
ENTRYPOINT ["java","-jar","/exemplo-spring-boot-thymeleaf.jar"]
