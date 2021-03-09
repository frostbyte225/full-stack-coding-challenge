FROM openjdk:11
VOLUME /tmp
COPY target/registration-service-0.0.1-SNAPSHOT.jar registration-service-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","registration-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8083