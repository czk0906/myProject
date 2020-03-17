package com.hlst.demo.redis;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * Redis key过期消息监听器
 * @author Czk
 *
 */
public class RedisMessageListener extends KeyExpirationEventMessageListener{

	private static Logger logger = (Logger) LoggerFactory.getLogger(RedisMessageListener.class);
	
	public RedisMessageListener(RedisMessageListenerContainer listenerContainer) {
		super(listenerContainer);
	}
	
	@Value("${spring.redis.host}")
	private String host;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		logger.info("#############################Redis的KEY过期监听器开始");
		System.out.println("HOSY:"+host);
		//接收消息频道
		String channel = new String(message.getChannel(),StandardCharsets.UTF_8);
		//过期的key
		String key = new String(message.getBody(),StandardCharsets.UTF_8);
		logger.info("key: "+key+"--------------监听频道: "+channel);
		//处理逻辑
		
		logger.info("#############################Redis的KEY过期监听器结束");
	}


	

}
