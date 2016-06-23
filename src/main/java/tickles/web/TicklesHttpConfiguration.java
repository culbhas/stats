package tickles.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.quartz.SimpleThreadPoolTaskExecutor;

@SpringBootApplication
@ComponentScan("tickles")
public class TicklesHttpConfiguration {

	public static void main(String[] args){
		SpringApplication.run(TicklesHttpConfiguration.class, args);
	}
	
	@Bean
	public TaskExecutor getTaskExecutor(){
		SimpleThreadPoolTaskExecutor executor = new SimpleThreadPoolTaskExecutor();
		executor.setThreadCount(10);
		return executor;
	}
	
	
}
