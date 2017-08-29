package com.kou.component;

import org.joda.time.LocalDateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by KouJiaxing on 2017-8-21.
 */
@Component("task")
public class SpringTask {

    @Scheduled(cron = "*/5 * * * * *")
    public void task(){
        System.out.println("================it is task TIME"+ LocalDateTime.now());
    }
}
