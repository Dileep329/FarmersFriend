package com.friend.farmers.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableCaching
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
//        config.setHostName("localhost");
//        config.setPort(6379);
//        return new LettuceConnectionFactory(config);
//    }

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory());
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return template;
//    }
}
