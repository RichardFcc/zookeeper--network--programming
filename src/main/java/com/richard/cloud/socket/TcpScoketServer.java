package com.richard.cloud.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpScoketServer {
    public static void main(String[] args) throws Exception{
        //建立服务端 socket 服务，并且监听一个端口
        ServerSocket ss = new ServerSocket(13131);
        //监听连接
        Socket s = ss.accept();

        //获取输入流，读取数据
        InputStream inputStream = s.getInputStream();
        byte[] bys = new byte[1024];
        int length = inputStream.read(bys);

        System.out.println(new String(bys,0,length));

        //关闭客户端
        s.close();

        //关闭服务端，一般服务端不关闭
        ss.close();
    }
}
