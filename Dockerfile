FROM openjdk:17
WORKDIR /app/mungpull
EXPOSE 8080
COPY build/libs/ddobagi-0.0.1.jar dbg.jar
ENTRYPOINT ["java", "-jar", "dbg.