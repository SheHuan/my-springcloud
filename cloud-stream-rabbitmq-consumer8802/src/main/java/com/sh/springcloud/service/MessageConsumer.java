package com.sh.springcloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyChannel.class)
public class MessageConsumer {

    @StreamListener(MyChannel.INPUT)
    public void receive(Object message) {
        System.out.println(message);
    }
}
