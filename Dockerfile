FROM maven:3.9.9

WORKDIR /app

COPY pom.xml /app

COPY . /app

RUN mvn clean package

CMD ["java", "-jar", "target/TripCostCalculator.jar"]