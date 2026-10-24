FROM eclipse-temurin:17
WORKDIR /app
RUN apt-get update && apt-get install -y nodejs npm
RUN npm install -g @angular/cli
#RUN which ng || echo "ng not found"
#RUN which node && node --version
COPY pom.xml mvnw ./
COPY .mvn/ .mvn/
RUN chmod +x mvnw
RUN sed -i 's/\r//' mvnw
RUN ./mvnw dependency:resolve
COPY src/ src/
RUN cd src/main/UI && npm install
RUN ./mvnw package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "/app/target/D387_sample_code-0.0.2-SNAPSHOT.jar"]
#docker run -p 8080:8080 --name D387_012344240 d387-app
