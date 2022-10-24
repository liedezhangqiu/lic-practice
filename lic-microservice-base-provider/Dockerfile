#ROM registry.cn-shenzhen.aliyuncs.com/lic-doc/lic-doc-sub
FROM java:8u45-jdk
MAINTAINER project-li
VOLUME /tmp/lic-microservice-base-provider
WORKDIR /tmp/lic-microservice-base-provider
COPY target/lic-microservice-base-provider-1.0-SNAPSHOT.jar  app.jar
#ADD ./../target/lic-microservice-base-provider-1.0-SNAPSHOT.jar /tmp/app.jar
EXPOSE 9008
ENTRYPOINT java -Dfile.encoding=UTF-8 -jar app.jar

# 演示环境GC参数：JAVA_OPS='-Xmx512m -Xms256m -XX:+UnlockDiagnosticVMOptions -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly
#  -XX:CMSInitiatingOccupancyFraction=70 -XX:AutoBoxCacheMax=20000 -XX:-UseBiasedLocking -XX:-UseCounterDecay
#  -XX:-OmitStackTraceInFastThrow -Djava.security.egd=file:/dev/urandom -XX:+CMSParallelInitialMarkEnabled -XX:+ParallelRefProcEnabled
#  -XX:+ExplicitGCInvokesConcurrent -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCDateStamps
#  -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+HeapDumpOnOutOfMemoryError -XX:+PerfDisableSharedMem -XX:+PrintCompressedOopsMode
#  -XX:-PrintGCApplicationStoppedTime'22222