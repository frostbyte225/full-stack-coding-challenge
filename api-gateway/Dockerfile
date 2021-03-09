FROM openjdk:11
VOLUME [ "/tmp" ]

COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "api-gateway-0.0.1-SNAPSHOT.jar" ]

EXPOSE 8765