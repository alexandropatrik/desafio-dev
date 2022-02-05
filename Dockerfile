FROM openjdk:11
VOLUME /tmp
ADD ./target/cnab-demo-0.0.1-SNAPSHOT.jar cnab-demo.jar
ENTRYPOINT ["java","-jar","/cnab-demo.jar"]