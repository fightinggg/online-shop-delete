package com.shop.goods;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class GoodsApplicationTests {
    private static Logger kafkaLogger = LoggerFactory.getLogger("kafka_logger");

    @Test
    public void sendLogToKafka() {
        for (int i = 0; i < 10; i++) {
            kafkaLogger.info("this is a test msg from kafka client " + i);
        }
    }

}



