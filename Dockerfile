# Use official base image of Java Runtim
FROM registry.access.redhat.com/ubi8/openjdk-8

ADD ROOT.jar ROOT.jar

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "ROOT.jar"]