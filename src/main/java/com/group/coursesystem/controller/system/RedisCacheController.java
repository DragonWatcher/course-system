package com.group.coursesystem.controller.system;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisCacheController {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @GetMapping("/redis-get/{param}")
    public String getCache(@PathVariable String param) {
        String redisVal = param + appendCurrentTime();
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        ListOperations<String, String> opsForList = stringRedisTemplate.opsForList();
//        opsForValue.set(param, redisVal);
        
        for (int i = 0; i < 3; i++) {
            opsForList.leftPush(param, i + "-" + param + appendCurrentTime());
        }
        // 只返回一个值
        String rightPop = opsForList.rightPop(param);
        
        System.out.println("redis添加缓存：" + param + " OK!");
        
        return rightPop;
    }
    
    
    @GetMapping("/redis-get")
    public String cacheObject() {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String key = "emp-01";
        opsForValue.set("emp-01", new Emp("张红玉", 23));
        Object obj = opsForValue.get(key).toString();
        return obj.toString();
    }
    
    private String appendCurrentTime() {
        return " : " + LocalDateTime.now().toString().replace("T", " ");
    }
    
    /**
     * 员工内部类
     * <br>类名：Emp<br>
     * 作者： mht<br>
     * 日期： 2019年1月19日-上午10:47:37<br>
     */
    public static class Emp {

        private String empName;

        private Integer age;

        public Emp(String empName, Integer age) {
            this.empName = empName;
            this.age = age;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "{empName : " + empName + ", age : " + age + "}";
        }
    }

}
