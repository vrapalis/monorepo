FROM openjdk:12-alpine
LABEL company="vrapalis" description="Api Gateway Service"
COPY ../build/libs /app
WORKDIR /app
EXPOSE 8080
RUN apk update && apk upgrade
ENTRYPOINT ["java", "-jar", "api-gateway-0.0.1-SNAPSHOT.jar"]
