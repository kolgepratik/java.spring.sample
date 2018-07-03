package com.kp.first.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

@Configuration
public class RedisConfig {
    public static String CONFIG_REDIS_HOST_NAME = "redis-18261.c12.us-east-1-4.ec2.cloud.redislabs.com";
    public static int CONFIG_REDIS_PORT = 18261;
    public static String CONFIG_REDIS_DB_PASSWORD = "zyn5egrn2PcLgLwu5aT5Z0E68WgVUcTL";
    public static String CONFIG_REDIS_DB_NAME = "app";
    public static HashMap<String, Integer> CONFIG_REDIS_DB_LIST;

    static {
        CONFIG_REDIS_DB_LIST = new HashMap<>();
        CONFIG_REDIS_DB_LIST.put(CONFIG_REDIS_DB_NAME, 0);
    }

}

@Configuration
class RedisConfigBean {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(RedisConfig.CONFIG_REDIS_HOST_NAME);
        redisStandaloneConfiguration.setPort(RedisConfig.CONFIG_REDIS_PORT);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(RedisConfig.CONFIG_REDIS_DB_PASSWORD));
        redisStandaloneConfiguration.setDatabase(RedisConfig.CONFIG_REDIS_DB_LIST.get(RedisConfig.CONFIG_REDIS_DB_NAME));

        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());

        return template;
    }
}
