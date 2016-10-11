FROM java:8-jre
MAINTAINER Pallav Tyagi <tyagi.pallav1601@gmail.com>

ADD gateway-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway-service.jar"]

EXPOSE 6000
