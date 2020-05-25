package com.shop.uid.service;

import com.xfvape.uid.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UidService {
    @Autowired
    UidGenerator uidGenerator;


    @Value("${kafka.uid.topic}")
    private String topic;

    static int x = 1;

    public long getUID() {
        return uidGenerator.getUID();
    }
}
