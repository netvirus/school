# Используем официальный образ с Java 17
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл сборки вашего приложения в контейнер
COPY target/*.jar /app/application.jar

# Запускаем ваше Spring Boot приложение
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
