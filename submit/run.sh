$HADOOP_HOME/bin/hadoop jar $JAR_FILEPATH $CLASS_TO_RUN $INPUT $OUTPUT
touch /tmp/ss.txt
tail -f /tmp/ss.txt
