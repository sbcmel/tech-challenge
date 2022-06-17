#specific image
FROM openjdk:17.0.2-oraclelinux8

#Label
LABEL org.opencontainers.image.authors=sbcmel
LABEL org.opencontainers.image.title=apiserver

#target proper shutdown
ENV TINI_VERSION v0.19.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /tini
RUN chmod +x /tini
ENTRYPOINT ["/tini", "--"]

# Exposing a port
EXPOSE 5000

WORKDIR '/app'
COPY build/libs/*SNAPSHOT.jar /app/spring-boot-application.jar
CMD ["java", "-jar", "spring-boot-application.jar"]
