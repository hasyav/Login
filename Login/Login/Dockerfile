FROM openjdk:8
ADD target/docker-login.jar docker-login.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-login.jar"]