package com.richard.cloud.zk;

import org.apache.zookeeper.*;

/**
 *
 */
public class TestZkClient2 {
    public static void main(String[] args) throws Exception {
        //构造java端zk客户端的实例（）
        ZooKeeper zk = new ZooKeeper("node-1:2181,node-2:2181", 30000, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("事件的类型为："+event.getType() );
                System.out.println("发生的路径："+event.getPath());
            }
        });
        // 创建一个目录节点
        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        // 创建一个子目录节点
                zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                       ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
                System.out.println(new String(zk.getData("/testRootPath",false,null)));
        // 取出子目录节点列表
                System.out.println(zk.getChildren("/testRootPath",true));
        // 修改子目录节点数据
                zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
                System.out.println("目录节点状态： ["+zk.exists("/testRootPath",true)+"]");
        // 创建另外一个子目录节点
                zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
                System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
        // 删除子目录节点
                zk.delete("/testRootPath/testChildPathTwo",-1);
                zk.delete("/testRootPath/testChildPathOne",-1);
        // 删除父目录节点
                zk.delete("/testRootPath",-1);
                zk.close();
    }
}

