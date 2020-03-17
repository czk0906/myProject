package com.hlst.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

	/** 载入配置文件配置的连接工厂 **/
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	

	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer() {
		RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
		redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
		return redisMessageListenerContainer;
	}

	@Bean
	public RedisMessageListener RedisMessageListener() {
		return new RedisMessageListener(this.redisMessageListenerContainer());
	}

	/*
	 * 不提示警告信息
	 * 
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @Autowired RedisTemplate redisTemplate;
	 * 
	 * @Bean RedisTemplate<String,Object> objectRedisTemplate(){
	 * RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
	 * redisTemplate.setConnectionFactory(redisConnectionFactory); return
	 * redisTemplate; }
	 * 
	 * @Bean
	 * 
	 * @Override public CacheManager cacheManager(){ RedisCacheManager
	 * redisCacheManager= new RedisCacheManager(redisTemplate); //设置缓存过期时间 //
	 * redisCacheManager.setDefaultExpiration(60);//秒 return redisCacheManager; }
	 */

	/**
	 * 重写缓存key生成策略，可根据自身业务需要进行自己的配置生成条件
	 * 
	 * @return
	 */
	/*
	 * @Bean
	 * 
	 * @Override public KeyGenerator keyGenerator() { return new KeyGenerator() {
	 * 
	 * @Override public Object generate(Object target, Method method, Object...
	 * params) { StringBuilder sb = new StringBuilder();
	 * sb.append(target.getClass().getName()); sb.append(method.getName()); for
	 * (Object obj : params) { sb.append(obj.toString()); } return sb.toString(); }
	 * }; }
	 */
	
	/**
     * 1.创建JedisPoolConfig对象。在该对象中完成一些链接池配置
     * @ConfigurationProperties:会将前缀相同的内容创建一个实体。
     */
    @Bean
    @ConfigurationProperties(prefix="spring.redis.pool")
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
		/*//最大空闲数
		config.setMaxIdle(10);
		//最小空闲数
		config.setMinIdle(5);
		//最大链接数
		config.setMaxTotal(20);*/
        System.out.println("默认值："+config.getMaxIdle());
        System.out.println("默认值："+config.getMinIdle());
        System.out.println("默认值："+config.getMaxTotal());
        return config;
    }

    /**
     * 2.创建JedisConnectionFactory：配置redis链接信息
     */
    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
        System.out.println("配置完毕："+config.getMaxIdle());
        System.out.println("配置完毕："+config.getMinIdle());
        System.out.println("配置完毕："+config.getMaxTotal());

        JedisConnectionFactory factory = new JedisConnectionFactory();
        //关联链接池的配置对象
        factory.setPoolConfig(config);
        //配置链接Redis的信息
        //主机地址
		factory.setHostName("134.175.144.124");
		//端口
		factory.setPort(6379);
        return factory;
    }

    /**
     * 3.创建RedisTemplate:用于执行Redis操作的方法
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);

        //为key设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //为value设置序列化器
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }


}
