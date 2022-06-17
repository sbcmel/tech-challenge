#specific image
FROM adoptopenjdk/openjdk17:alpine-jre

#Label
LABEL org.opencontainers.image.authors=sbcmel
LABEL org.opencontainers.image.title=apiserver

#target proper shutdown
ENV TINI_VERSION v0.19.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini /tini
RUN chmod +x /tini
ENTRYPOINT ["/tini", "--"]

# Exposing a port
EXPOSE 8080
EXPOSE 80

WORKDIR '/app'
COPY build/libs/*.jar /app/spring-boot-application.jar
CMD ["java", "-jar", "spring-boot-application.jar"]

