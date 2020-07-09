# Builder
FROM oracle/graalvm-ce:20.1.0-java11 AS builder
COPY  . /root/app/
WORKDIR /root/app
RUN ./mvnw clean package

# Application
FROM oracle/graalvm-ce:20.1.0-java11 AS application
COPY --from=builder /root/app/target/*.jar /home/app/
WORKDIR /home/app
EXPOSE 8080
ENTRYPOINT java -jar $JAVA_OPTIONS *.jar $APP_ARGS
