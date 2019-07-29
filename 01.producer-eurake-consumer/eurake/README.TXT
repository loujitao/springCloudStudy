通过idea的VM options选项填写下列值。
eurake单机版启动方式：
    -Dspring.profiles.active=alone  启动单节点

 eurake双节点相互注册版启动方式：
     -Dspring.profiles.active=peer1  启动节点1
     -Dspring.profiles.active=peer2  启动节点2


如果打成jar包了,通过下列命令启动
eurake单机版启动方式：
    java -jar eurake.jar --spring.profiles.active=alone  启动单节点

 eurake双节点相互注册版启动方式：
    java -jar eurake.jar --spring.profiles.active=peer1  启动节点1
    java -jar eurake.jar --spring.profiles.active=peer2  启动节点2

