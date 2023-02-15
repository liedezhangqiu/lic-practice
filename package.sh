
#--add-exports=java.base/jdk.internal.vm.annotation=ALL-UNNAMED
#--add-exports=java.base/sun.net=ALL-UNNAMED
#--add-exports=java.base/sun.net.util=ALL-UNNAMED
#--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED
#--add-exports=java.base/sun.net.www=ALL-UNNAMED
mvn clean package -Dmaven.test.skip=true