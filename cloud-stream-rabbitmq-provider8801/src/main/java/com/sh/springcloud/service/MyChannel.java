package com.sh.springcloud.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyChannel {
    String OUTPUT = "stream-output";

    @Output(OUTPUT)
    MessageChannel output();
}
