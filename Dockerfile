FROM java:8
EXPOSE 8080
ADD target/ForexExchange-0.0.1-SNAPSHOT.jar forexexchange.jar
ENTRYPOINT ["java" ,"-jar","forexexchange.jar"]