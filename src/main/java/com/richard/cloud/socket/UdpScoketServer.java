package com.richard.cloud.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpScoketServer {
    public static void main(String[] args) throws Exception{
       
        //创建服务端Scoket对象
        DatagramSocket socket = new DatagramSocket(12306);

        //创建数据包（接收容器）
            //设置1024的目的：不足1024返回-1
        byte[] bys = new byte[1024];

        DatagramPacket packet = new DatagramPacket(bys,bys.length);
        //接收数据
        socket.receive(packet);
        //数据解析

        byte[] data = packet.getData();
        System.out.println(new String(data));

        //释放资源
        socket.close();
    }
}
