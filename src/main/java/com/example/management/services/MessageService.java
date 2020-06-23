package com.example.management.services;

import com.example.management.model.Message;
import com.example.management.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;





}
