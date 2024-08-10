FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/StudentManagementSystem.jar studentmanagementsystem.jar
ENTRYPOINT ["java","-jar","/studentmanagementsystem.jar"]
EXPOSE 9090