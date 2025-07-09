FROM archlinux:base

# Install dependencies
RUN pacman -Syu --noconfirm jdk17-openjdk maven

# Setup
EXPOSE 8082
COPY ./src .

# Build
RUN mvn compile
RUN mvn test
RUN mvn clean
RUN mvn package
RUN mvn exec:java -Dexec.mainClass="com.perilousbooklet.app.App"

# Run
CMD ["java", "-jar", "target/src-1.0-SNAPSHOT.jar"]
