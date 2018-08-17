/**
 * 
 */
package redis;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @author huangyuan
 * @date 2018年7月14日上午11:58:28
 * @Description 创建一个连接池
 */
public class jedisPoolUtils {
	private static JedisPool jedisPool=null;
	
	private jedisPoolUtils() {}
	//采用双重检验锁 来实现单例模式
	public static JedisPool initial() {
		if (jedisPool==null) {
			synchronized (jedisPoolUtils.class) {
				if (jedisPool==null) {
					
					JedisPoolConfig config = new JedisPoolConfig();
					config.setMaxIdle(30);
					config.setMaxTotal(1000);
					config.setTestOnBorrow(true);
					config.setMaxWaitMillis(3000);
					
					jedisPool=new JedisPool(config,"47.106.39.238",6379);
							
				}
			}
		}
		return jedisPool;
	}
	public static void release(JedisPool jedisPool,Jedis jedis) {
		if (jedis!=null) {
			jedisPool.returnResourceObject(jedis);
		}
	}
	//Redis服务器IP
   /* private static String ADDR = "127.0.0.1";
    
    //Redis的端口号
    private static int PORT = 6379;
    
    //访问密码,若你的redis服务器没有设置密码，就不需要用密码去连接
    private static String AUTH = "123456";
    
    //可用连接实例的最大数目，默认值为8；
    private static int MAX_TOTAL = 512;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 50;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。
    private static long MAX_WAIT = 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
    
    *//**
     * 初始化Redis连接池
     *//*
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWait(MAX_WAIT);
   
            config.setTestOnBorrow(TEST_ON_BORROW);
         
            jedisPool=new JedisPool(config, ADDR, PORT);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    *//**
     * 获取Jedis实例
     * @return
     *//*
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis jedis = jedisPool.getResource();
                return jedis;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    *//**
     * 释放jedis资源
     * @param jedis
     *//*
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }*/
}
