FROM openjdk:8-jdk-alpine
LABEL maintainer="jamescollerton@live.co.uk"
VOLUME /tmp
ADD /target/artservicefrontend*.jar artservicefrontend.jar
CMD java -jar artservicefrontend.jar