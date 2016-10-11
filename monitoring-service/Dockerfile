FROM java:8-jre
MAINTAINER Pallav Tyagi <tyagi.pallav1601@gmail.com>

ADD monitoring-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/monitoring-service.jar"]

EXPOSE 6000
