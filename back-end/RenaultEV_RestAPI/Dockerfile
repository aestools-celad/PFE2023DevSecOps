#FROM openjdk:11.0.16-jdk
#COPY --chown=appuser:appuser ./back-end/RenaultEV_RestAPI/target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]

# Set the base image
FROM maven:3.8.4-openjdk-11-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY ./src ./src
RUN mvn package -DskipTests




# Set the base image for the final image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the .jar file from the build image
COPY --from=build /app/target/*.jar app.jar

# Expose the default port
EXPOSE 8080

# Set the default command to run the JAR file
CMD ["java", "-jar", "app.jar"]




