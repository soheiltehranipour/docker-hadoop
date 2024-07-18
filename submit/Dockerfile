FROM bde2020/hadoop-base:2.0.0-hadoop3.2.1-java8

COPY sample-app.jar /opt/hadoop/applications/sample-app.jar

ENV JAR_FILEPATH="/opt/hadoop/applications/sample-app.jar"
ENV CLASS_TO_RUN="org.apache.hadoop.examples.WordCount"
ENV INPUT="/user/root/input"
ENV OUTPUT=" /user/root/output12345"

ADD run.sh /run.sh
RUN chmod a+x /run.sh

CMD ["/run.sh"]
