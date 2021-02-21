FROM openjdk:17-ea-10
COPY "./target/clinicasur.jar" "clinicasurapp.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","clinicasurapp.jar"]
