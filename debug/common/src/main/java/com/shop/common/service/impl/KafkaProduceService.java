package com.shop.common.service.impl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@EnableBinding(Source.class)
public class KafkaProduceService {
    private Source mySource;
}
