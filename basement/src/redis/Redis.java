package redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Redis {
	@Test
	public void test() {
		Jedis jedis=new Jedis();
		System.out.println("连接成功");
		//查看服务是否运行
		System.out.println("服务正在运行"+jedis.ping());
	}
	/**
	 * Redis Java String(字符串) 实例
	 */
	@Test
	public void test2() {
		//连接本地redis
		Jedis jedis =new Jedis("localhost");
		//设置redis字符串数据
		jedis.set("runoobkey", "www.runoob.com");
		//获取存储的数据并输出
		System.out.println("redis存储的字符串为"+jedis.get("runoobkey"));
	}
	
	/**
	 * Redis Java List(列表) 实例
	 */
	@Test
	public void test3() {
		//连接本地redis
		Jedis jedis =new Jedis("47.106.39.238");
		 //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        list.forEach((a)->System.out.println("列表项为: "+a));
       
	}
	
	
	/**
	 * Redis Java Keys 实例
	 */
	@Test
	public void test4() {
		  //连接本地的 Redis 服务
        Jedis jedis = new Jedis("47.106.39.238",6379);
        System.out.println("连接成功");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        keys.forEach((a)->System.out.println("列表项为: "+a));
        
        
      //zset
        jedis.zadd("zset01", 60d, "v1");
        jedis.zadd("zset01", 70d, "v2");
        jedis.zadd("zset01", 80d, "v3");
        
        Set<String> zrange = jedis.zrange("zset01", 0, -1);
        zrange.forEach((set)->System.out.println("zset01的数据为"+set));
        
        //hash
        Map<String, String> map=new HashMap<>();
        map.put("h1","10");
        map.put("h2","20");
        map.put("h3","30");
        jedis.hmset("hash", map);
        
        jedis.close();
	}
	
	
}
