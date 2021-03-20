FROM maven as builder
WORKDIR /code/
COPY pom.xml /code/
RUN mvn clean verify --fail-never 
COPY /src /code/src
RUN mvn package

FROM openjdk:11-jre
COPY --from=builder /code/target/*.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java"]
CMD ["-jar", "planner-0.0.1-SNAPSHOT.jar"]
