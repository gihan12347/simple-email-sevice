# Use an official Tomcat image with Java 8
FROM tomcat:9.0-jdk8-openjdk

# Remove the default web apps (optional)
# Create the /app directory in the container
RUN mkdir -p /app

# Now copy the WAR file to the container's /app directory
COPY ./build/libs/physicalTrainerAdmin.war /usr/local/tomcat/webapps/

# Expose port 8080 for Tomcat
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]


