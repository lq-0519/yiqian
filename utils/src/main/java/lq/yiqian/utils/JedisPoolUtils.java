package lq.yiqian.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author LQ
 * @create 2020-09-18 16:49
 */

/**
 * Redis连接池工具类
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        // 读取配置信息
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));// 设置最大连接数
        jedisPoolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));// 设置连接池中常驻的连接数
        jedisPool = new JedisPool(jedisPoolConfig, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }

    /**
     * 返回连接对象
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
