FROM tomcat:9.0.65-jdk11-corretto-al2

RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/DockerPractice.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]