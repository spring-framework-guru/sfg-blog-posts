FROM openjdk:11
WORKDIR usr/src
COPY ./pom.xml ./pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY ./src ./src
RUN ["chmod", "+x", "mvnw"]
RUN ./mvnw dependency:go-offline -B
RUN ./mvnw clean package && cp target/publish-docker-image-to-docker-hub-1.0-SNAPSHOT.jar publish-docker-image-to-docker-hub-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "publish-docker-image-to-docker-hub-1.0-SNAPSHOT.jar"]
