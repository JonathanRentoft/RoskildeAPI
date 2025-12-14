# 1. Build fasen: Her henter vi Maven og bygger projektet
FROM maven:3.9-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Byg jar-filen (skipper tests for hurtigere build)
RUN mvn clean package -DskipTests

# 2. Run fasen: Her kører vi den færdige jar fil
FROM amazoncorretto:17-alpine
WORKDIR /app
# Kopier den byggede jar fil fra build-fasen
# HUSK: Tjek i din pom.xml hvad din jar hedder. Ofte er det 'din-app-1.0-SNAPSHOT.jar'
# Hvis du er i tvivl, så kald den bare 'app.jar' i outputtet, eller brug wildcard *.jar
COPY --from=build /app/target/*.jar app.jar

# Eksponer porten (Din app bruger 7071)
EXPOSE 7071

# Start lortet
CMD ["java", "-jar", "app.jar"]