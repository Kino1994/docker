FROM maven as builder
WORKDIR /code/
COPY pom.xml /code/
COPY /src /code/src
RUN mvn clean verify --fail-never 
RUN mvn package

FROM openjdk:11-jre
WORKDIR /usr/app
COPY --from=builder /code/target/*.jar /usr/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java"]
CMD ["-jar", "app.jar"]
