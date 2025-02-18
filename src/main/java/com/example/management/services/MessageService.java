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

    /**
     * add messages collection
     * @param messageList {@link java.util.ArrayList}
     */
    public void saveMessage(Message[] messageList) {
        assert messageList != null;
        for (Message msg:messageList) {
            messageRepository.save(msg);
        }
    }

    /**
     * get All Messages
     * @return {@link java.util.ArrayList}
     */
    public List<Message> getAllMessages()  {
        return messageRepository.findByOrderByTitleAsc();
    }


}
