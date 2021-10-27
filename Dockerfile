FROM java:8
EXPOSE 8086
ADD /target/job-microservice-0.0.1-SNAPSHOT.jar docker-job.jar
ENTRYPOINT ["java","-jar","docker-job.jar"]