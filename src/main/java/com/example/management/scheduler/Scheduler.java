package com.example.management.scheduler;


import com.example.management.model.Message;
import com.example.management.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class Scheduler {

    @Autowired
    MessageService messageService;

    @Scheduled(cron = "1 * * * * ?")
    public void cronJobSch() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);

        final String uri = "https://jsonplaceholder.typicode.com/posts";

        RestTemplate restTemplate = new RestTemplate();
        Message[] result = restTemplate.getForObject(uri, Message[].class);
        assert result != null;
        messageService.saveMessage(result);

    }
}
