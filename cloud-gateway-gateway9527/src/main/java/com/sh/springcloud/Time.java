package com.sh.springcloud;

import java.time.ZonedDateTime;

public class Time {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
