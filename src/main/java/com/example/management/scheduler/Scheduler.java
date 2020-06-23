package com.example.management.scheduler;


import com.example.management.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class Scheduler {

    @Autowired
    MessageService messageService;

    @Scheduled(cron = "1 * * * * ?")
    public void cronJobSch() {

    }
}
