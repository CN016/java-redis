package com.my016.redisspringboot.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedispool ;
    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(0);

        jedisPoolConfig.setMaxWaitMillis(200);
        jedispool = new JedisPool(jedisPoolConfig,"192.168.1.116",9810,1000,"016016");

    }
    public static Jedis getJedis(){
        return jedispool.getResource();
    }
}
