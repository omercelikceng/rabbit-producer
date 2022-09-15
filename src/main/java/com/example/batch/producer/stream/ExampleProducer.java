package com.example.batch.producer.stream;

import com.example.batch.data.ExampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleProducer {

    @Autowired
    private StreamBridge streamBridge;

    public void sendExampleData1() {
        for (int i = 0; i < 100; i++) {
            streamBridge.send("sendExampleData1-out-0", new ExampleData(i));
        }
        System.out.println("BASTIM");
    }

}
