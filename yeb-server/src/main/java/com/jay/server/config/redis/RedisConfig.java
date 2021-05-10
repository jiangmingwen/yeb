package com.jay.server.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //string类型key序列化
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        //string类型value序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //Hash类型key序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //Hash类型value序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
