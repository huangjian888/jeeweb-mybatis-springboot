package cn.jeeweb.modules.task.task;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskTest {
	public final Logger log = Logger.getLogger(this.getClass());
 
	public void run() {
		for (int i = 0; i < 10; i++) {
			log.info(i+" run......................................" + (new Date()));
		}

	}

	public void run1() {
		for (int i = 0; i < 10; i++) {
			log.info(i+" run1......................................" + (new Date()));
		}
	}
}
