package com.sh.springcloud.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MyChannel {
    String INPUT = "stream-input";

    @Input(INPUT)
    SubscribableChannel input();
}
