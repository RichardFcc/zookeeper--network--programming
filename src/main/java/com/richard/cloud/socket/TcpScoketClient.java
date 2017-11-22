package com.richard.cloud.socket;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpScoketClient {
    public static void main(String[] args) throws Exception{
       
        //创建客户端的 socket 服务，指定目的主机和端口
        InetAddress address = InetAddress.getLocalHost();
        Socket s = new Socket(address,13131);

        //通过 socket 获取输出流，写数据
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("hello,TcpSocketClient.".getBytes());
        //释放资源
        s.close();
    }
}
