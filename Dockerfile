# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /src

# Copy the Spring Boot application JAR file into the container
# Replace 'your-application.jar' with the actual name of your compiled JAR
COPY target/HelloWorld-0.0.1-SNAPSHOT.jar HelloWorld-0.0.1-SNAPSHOT.jar.original.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "HelloWorld-0.0.1-SNAPSHOT.jar.original.jar"]