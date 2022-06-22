FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/delivery-0.0.1-SNAPSHOT.jar deliverysystem.jar
ENTRYPOINT ["java","-jar","/deliverysystem.jar"]
