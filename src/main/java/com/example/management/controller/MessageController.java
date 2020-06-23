package com.example.management.controller;

import com.example.management.model.Message;
import com.example.management.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Aarboun on 19/06/2020.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    MessageService messageService;

    /**
     * addMessages
     * @return boolean
     */
    @GetMapping("/addmessages")
    public boolean addMessages(){
        try {
            final String uri = "https://jsonplaceholder.typicode.com/posts";
            RestTemplate restTemplate = new RestTemplate();
            Message[] result = restTemplate.getForObject(uri, Message[].class);
            assert result != null;
            messageService.saveMessage(result);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * get All Messages
     * @return {@link java.util.ArrayList}
     */
    @GetMapping("/message")
    public List<Message> getAllMessages()  {
        return messageService.getAllMessages();
    }

}
