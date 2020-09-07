package com.xzy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class AppTest {

    @Test
    public void testConnection() {
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.auth("0317gjj");
        System.out.println("连接成功！");
        System.out.println("正在连接：" + jedis.ping());

    }
}
