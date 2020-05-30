#Dockerfile contains all the commands with which
#Docker can build images reading the instructions.

FROM openjdk:11

ADD ./target/spring-boot-docker-2.2.6.RELEASE.jar /usr/src/spring-boot-docker-2.2.6.RELEASE.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "spring-boot-docker-2.2.6.RELEASE.jar"]