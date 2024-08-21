FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/StudentManagementSystem.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9090