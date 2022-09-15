package com.example.batch.producer.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

@Component
public class ExampleService implements Runnable {

    @Autowired
    private ExampleProducer exampleProducer;

    @Override
    public void run() {
//        while(true) {
//            exampleProducer.sendExampleData1();
//        }
    }
}
