JAVA_MEM_OPTS="-server -Xmx2g -Xms2g -Xmn256m \
-XX:PermSize=128m \
-Xss384k \
-XX:+DisableExplicitGC \
-XX:+UseConcMarkSweepGC \
-XX:+CMSParallelRemarkEnabled \
-XX:+UseCMSCompactAtFullCollection \
-XX:LargePageSizeInBytes=128m \
-XX:+UseFastAccessorMethods \
-XX:+UseCMSInitiatingOccupancyOnly \
-XX:CMSInitiatingOccupancyFraction=70"
java $JAVA_MEM_OPTS -jar lic-microservice-base-provider/target/lic-microservice-base-provider-1.0-SNAPSHOT.jar