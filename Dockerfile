# Use the official OpenJDK image as the base image
FROM openjdk:17

# Set the working directory within the container
WORKDIR /social-media

# Copy the packaged JAR file from the target directory into the container
COPY target/SocialMedia-backend-0.0.1-SNAPSHOT.jar social-media.jar
# Expose the port that your application runs on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "social-media.jar"]