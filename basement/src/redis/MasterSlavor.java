/**
 * 
 */
package redis;



import redis.clients.jedis.Jedis;

/**
 * @author huangyuan
 * @date 2018年7月14日上午11:03:07
 * @Description 主从复制
 */
public class MasterSlavor {
	
	public static void main(String[] args) {
		//主机
		Jedis jedisM = new Jedis("47.106.39.238",6379);
		//从机
		Jedis jedisS = new Jedis("47.106.39.238",6380);
		
		jedisS.slaveof("47.106.39.238",6379);
		
		//主机写
		jedisS.set("k5", "v5");
		//从机读
		String string = jedisM.get("K5");
		System.out.println(string );
		jedisS.close();
		jedisM.close();
	}
}
