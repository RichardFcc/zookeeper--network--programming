package com.richard.cloud.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSocketClient {
    public static void main(String[] args) throws Exception{
        
        // 创建发送端socket对象
        DatagramSocket socketClient = new DatagramSocket();
        
        //把发送的数据打包
          String message = "Hello,richard!";
          byte[] bys =message.getBytes();
          int length = bys.length;
        InetAddress address = InetAddress.getLocalHost();

        int port = 12306;
        DatagramPacket packet =new DatagramPacket(bys,length,address,port);

        //发送打包好的数据
         socketClient.send(packet);
        //资源的释放
        socketClient.close();

    }
}
