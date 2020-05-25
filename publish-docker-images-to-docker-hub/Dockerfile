#Dockerfile contains all the commands with which
#Docker can build images reading the instructions.

FROM openjdk:11

ADD ./target/publish-docker-images-to-docker-hub-2.2.6.RELEASE.jar /usr/src/publish-docker-images-to-docker-hub-2.2.6.RELEASE.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "publish-docker-images-to-docker-hub-2.2.6.RELEASE.jar"]