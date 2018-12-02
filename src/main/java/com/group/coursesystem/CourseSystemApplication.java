package com.group.coursesystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * spring boot set up class
 * <br>类名：CourseSystemApplication<br>
 */
@EnableJpaRepositories
@SpringBootApplication
public class CourseSystemApplication {
    private static final Logger logger = LoggerFactory.getLogger(CourseSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CourseSystemApplication.class, args);
		logger.info("--------------------服务器启动完毕--------------------");
	}
}
