#FROM registry.cn-shenzhen.aliyuncs.com/lic-doc/lic-doc-sub:lic-jdk8
FROM java:8
VOLUME /tmp
MAINTAINER project
ARG JAR_FILE
ADD /target/lic-microservice-base-provider-1.0-SNAPSHOT.jar app.jar
EXPOSE 2188
ENTRYPOINT java ${JAVA_OPTS} -Duser.timezone=Asia/Shanghai -Dfile.encoding=UTF-8 -jar app.jar

# 演示环境GC参数：JAVA_OPS='-Xmx512m -Xms256m -XX:+UnlockDiagnosticVMOptions -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly
#  -XX:CMSInitiatingOccupancyFraction=70 -XX:AutoBoxCacheMax=20000 -XX:-UseBiasedLocking -XX:-UseCounterDecay
#  -XX:-OmitStackTraceInFastThrow -Djava.security.egd=file:/dev/urandom -XX:+CMSParallelInitialMarkEnabled -XX:+ParallelRefProcEnabled
#  -XX:+ExplicitGCInvokesConcurrent -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCDateStamps
#  -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+HeapDumpOnOutOfMemoryError -XX:+PerfDisableSharedMem -XX:+PrintCompressedOopsMode
#  -XX:-PrintGCApplicationStoppedTime'