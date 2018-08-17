/**
 * 
 */
package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author huangyuan
 * @date 2018年7月14日下午1:00:49
 * @Description
 */
public class PoolTest {
	final JedisPool jedisPool=jedisPoolUtils.initial();//初始化一个线程池

	@Test
	public void test() {
		//从线程池里面获取一个Jedis实例
		Jedis jedis = jedisPool.getResource();
		jedis.set("k6", "v6");
		jedisPoolUtils.release(jedisPool, jedis);//用完放回去
	}
}
