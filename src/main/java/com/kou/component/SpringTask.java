package com.kou.component;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 * Created by KouJiaxing on 2017-8-21.
 */
@Component("task")
public class SpringTask {

    public void task() {
        System.out.println("================it is task TIME" + LocalDateTime.now());
    }
}
