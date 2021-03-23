FROM maven as builder
WORKDIR /code/
COPY pom.xml /code/
COPY /src /code/src
RUN mvn clean verify --fail-never 
RUN mvn package

FROM openjdk:11-jre
WORKDIR /usr/app
COPY --from=builder /code/target/*.jar /usr/app/app.jar
RUN curl -LJO https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh && chmod +x /usr/app/wait-for-it.sh
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
