FROM lic-jdk8
MAINTAINER /tmp
ARG JAR_FILE
ADD /target/${JAR_FILE} app.jar
EXPOSE 2188
ENTRYPOINT java ${JAVA_OPTS} -Duser.timezone=Asia/Shanghai -Dfile.encoding=UTF-8 -jar app.jar

# 演示环境GC参数：JAVA_OPS='-Xmx512m -Xms256m -XX:+UnlockDiagnosticVMOptions -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly
#  -XX:CMSInitiatingOccupancyFraction=70 -XX:AutoBoxCacheMax=20000 -XX:-UseBiasedLocking -XX:-UseCounterDecay
#  -XX:-OmitStackTraceInFastThrow -Djava.security.egd=file:/dev/urandom -XX:+CMSParallelInitialMarkEnabled -XX:+ParallelRefProcEnabled
#  -XX:+ExplicitGCInvokesConcurrent -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCDateStamps
#  -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+HeapDumpOnOutOfMemoryError -XX:+PerfDisableSharedMem -XX:+PrintCompressedOopsMode
#  -XX:-PrintGCApplicationStoppedTime'