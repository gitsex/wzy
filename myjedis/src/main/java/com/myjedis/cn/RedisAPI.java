package com.myjedis.cn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**   
 * Redis�����ӿ�
 *
 * @author �ּ���
 * @version 1.0 2013-6-14 ����08:54:14   
 */
@Component
public class RedisAPI {
    private static JedisPool pool = null;
    @Autowired
    private static JedisPoolConfig config ;
    /**
     * ����redis���ӳ�
     * 
     * @param ip
     * @param port
     * @return JedisPool
     */
    private static  JedisPool getPool() {
        if (pool == null) {
            
//            //����һ��pool�ɷ�����ٸ�jedisʵ����ͨ��pool.getResource()����ȡ��
//            //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
//            config.setMaxActive(500);
//            //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����
//            config.setMaxIdle(5);
//            //��ʾ��borrow(����)һ��jedisʵ��ʱ�����ĵȴ�ʱ�䣬��������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
//            config.setMaxWait(1000 * 100);
//            //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
//            config.setTestOnBorrow(true);
            pool = new JedisPool(config, "127.0.0.1", 6379);
        }
        return pool;
    }
    
    /**
     * ���������ӳ�
     * 
     * @param pool 
     * @param redis
     */
    public static void returnResource(JedisPool pool, Jedis redis) {
        if (redis != null) {
            pool.returnResource(redis);
        }
    }
    
    /**
     * 
     * ��ȡ����
     */
    public static Jedis getJedis(){
    	if(pool!=null){
    		return pool.getResource();
    	}else{
    		getPool();
    		getJedis();
    	}
    	return null;
    }
    /**
     * ��ȡ����
     * 
     * @param key
     * @return
     */
 /*   public static String get(String key){
        String value = null;
        
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            //�ͷ�redis����
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //���������ӳ�
            returnResource(pool, jedis);
        }
        
        return value;
    }*/
}