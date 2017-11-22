package com.richard.cloud.zk;

import org.apache.zookeeper.*;

/**
 *
 */
public class TestZkClient {
    public static void main(String[] args) throws Exception {
        //构造java端zk客户端的实例（）
        ZooKeeper zooKeeper = new ZooKeeper("node-1:2181,node-2:2181", 30000, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println(event.getType() );
                System.out.println(event.getPath());
            }
        });
      
        //创建节点（                节点   +        数 据  +               ACL权限+                         节点的类型）
        zooKeeper.create("/zkjava","hello zk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.close();
    }
}

