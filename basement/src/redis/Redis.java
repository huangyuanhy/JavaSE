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
		System.out.println("���ӳɹ�");
		//�鿴�����Ƿ�����
		System.out.println("������������"+jedis.ping());
	}
	/**
	 * Redis Java String(�ַ���) ʵ��
	 */
	@Test
	public void test2() {
		//���ӱ���redis
		Jedis jedis =new Jedis("localhost");
		//����redis�ַ�������
		jedis.set("runoobkey", "www.runoob.com");
		//��ȡ�洢�����ݲ����
		System.out.println("redis�洢���ַ���Ϊ"+jedis.get("runoobkey"));
	}
	
	/**
	 * Redis Java List(�б�) ʵ��
	 */
	@Test
	public void test3() {
		//���ӱ���redis
		Jedis jedis =new Jedis("47.106.39.238");
		 //�洢���ݵ��б���
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // ��ȡ�洢�����ݲ����
        List<String> list = jedis.lrange("site-list", 0 ,2);
        list.forEach((a)->System.out.println("�б���Ϊ: "+a));
       
	}
	
	
	/**
	 * Redis Java Keys ʵ��
	 */
	@Test
	public void test4() {
		  //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("47.106.39.238",6379);
        System.out.println("���ӳɹ�");

        // ��ȡ���ݲ����
        Set<String> keys = jedis.keys("*"); 
        keys.forEach((a)->System.out.println("�б���Ϊ: "+a));
        
        
      //zset
        jedis.zadd("zset01", 60d, "v1");
        jedis.zadd("zset01", 70d, "v2");
        jedis.zadd("zset01", 80d, "v3");
        
        Set<String> zrange = jedis.zrange("zset01", 0, -1);
        zrange.forEach((set)->System.out.println("zset01������Ϊ"+set));
        
        //hash
        Map<String, String> map=new HashMap<>();
        map.put("h1","10");
        map.put("h2","20");
        map.put("h3","30");
        jedis.hmset("hash", map);
        
        jedis.close();
	}
	
	
}
