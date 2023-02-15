from py4j.java_gateway import JavaGateway
import json

jway = JavaGateway()

print(jway.jvm)

print(jway.jvm.__class__)
pvm = jway.jvm

random = pvm.java.util.Random()
print(random.nextInt(1222))

ps = pvm.cn.lic.microservice.base.provider.BaseApplication
# 系统信息
jss = json.loads(ps.getSystemProperties())
for j in jss:
    print(str(j) + " : " + jss[j])

print('--------------')
gss = json.loads(ps.getG())
for j in gss:
    print('++++++++++++++++')
    for je in j:
        print(str(je) + " : " + str(j[je]))

a = pvm.com.lic.netty.client.side.util.At
print(a.get())
res = a.get()
print(res)
import Message_pb2

messageBase = Message_pb2.MessageBase()
messageBase.ParseFromString(res)

print(messageBase)

m = pvm.com.lic.netty.client.side.util.At.getM()
print(m)
messageBase1 = Message_pb2.MessageBase()
messageBase1.ParseFromString(m.toString())
print(messageBase1)

# a=mjvm.com.lic.job.quartz.episode2.utils.AsciiUtils
#
# print(a.strToAscii("test"))
#
# detJob = mjvm.detectJob
# print(detJob)
# print(detJob.jobHandle())
