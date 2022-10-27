package com.my016.redisspringboot.Jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class StartDemo1Test {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        //建立连接
        jedis = new Jedis("192.168.1.116",9810);
        //设置密码
        jedis.auth("016016");
        //选择库
        jedis.select(0);
    }

    @Test
    void testString(){
        String result = jedis.set("name","016");
        System.out.println("result = " + result);

        String name = jedis.get("name");
        System.out.println("name = "+name);
    }

    @Test
    void testHash(){
        jedis.hset("user:1" , "name","Jack");
        jedis.hset("user:1","age","21");
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);

    }

    @AfterEach
    void tearDown(){
        if (jedis!=null){
            jedis.close();
        }
    }
}
