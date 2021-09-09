# Use official base image of Java Runtim
FROM openjdk:8-jdk-alpine

ADD ROOT.jar ROOT.jar

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "ROOT.jar"]