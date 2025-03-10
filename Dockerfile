FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

# Dar permissão de execução ao gradlew
RUN chmod +x ./gradlew

# Executar o build
RUN ./gradlew build -x test

EXPOSE 8085

# Comando para iniciar a aplicação
#CMD ["sh", "-c", "java -jar build/libs/*.jar"]
CMD ["./gradlew", "bootRun"]