FROM bde2020/hadoop-base:2.0.0-hadoop3.2.1-java8
COPY sample-app.jar /tmp/sample-app.jar
ADD run.sh /tmp/run.sh
RUN chmod +x /tmp/run.sh
CMD ["/tmp/run.sh"]
