package com.group.coursesystem.config;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SysCacheKeyGenerator {

    /**
     * 课程缓存key生成策略
     */
    @Bean("courseDefaultKeyGenerator")
    public KeyGenerator courseCacheKeyGenerator() {
        return new KeyGenerator() {

            @Override
            public Object generate(Object target, Method method, Object... params) {
                String key = params.length == 0 ? "courseList" : params.toString();
                return method.getName() + "." + key;
            }
        };
    }
}
