package com.sh.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(MyChannel.class)
public class MessageProvider {
    @Autowired
    private MyChannel myChannel; // 消息发送管道

    public String send() {
        String uuid = UUID.randomUUID().toString();
        myChannel.output().send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }
}
