package com.richard.cloud.io;

import java.net.InetAddress;

public class TestInetAdress {
    public static void main(String[] args) throws Exception {
       
        InetAddress adress = InetAddress.getLocalHost();

        System.out.println(adress.getAddress());
        System.out.println(adress.getHostAddress());
        System.out.println(adress.getHostName());
    }

}
