FROM openjdk:11
VOLUME /tmp 
COPY target/login-service-0.0.1-SNAPSHOT.jar login-service-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","login-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081