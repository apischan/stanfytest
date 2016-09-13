FROM openjdk:8-jre
COPY build/installShadow/stanfytest-rest/lib /
COPY start.sh /
RUN sh -c 'chmod u+x /start.sh'
ENTRYPOINT ["java", "-jar", "/stanfytest-rest-1.0-SNAPSHOT-all.jar"]