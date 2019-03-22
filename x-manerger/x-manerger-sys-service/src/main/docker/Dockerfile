#所有资源以及依赖库都在jar中
FROM java:8
VOLUME /tmp
ADD manerger-sys-service.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#项目结构为：主程序+依赖库+配置+资源
FROM java:8
RUN mkdir /data/server -p
WORKDIR /data/server
ADD manerger-sys-service.jar app.jar
COPY bin bin
COPY config config
COPY lib lib
COPY logs logs
COPY resources resources
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

#存储异常日志
ENV JAVA_OPTS="\
-server \
-Xmx4g \
-Xms4g \
-Xmn2g \
-XX:SurvivorRatio=8 \
-XX:MetaspaceSize=256m \
-XX:MaxMetaspaceSize=512m \
-XX:+UseParallelGC \
-XX:ParallelGCThreads=4 \
-XX:+UseParallelOldGC \
-XX:+UseAdaptiveSizePolicy \
-XX:+PrintGCDetails \
-XX:+PrintTenuringDistribution \
-XX:+PrintGCTimeStamps \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/ \
-Xloggc:/gc.log \
-XX:+UseGCLogFileRotation \
-XX:NumberOfGCLogFiles=5 \
-XX:GCLogFileSize=10M"
ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar