package com.example.batch.producer.stream;

import com.example.batch.data.ExampleData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class ExampleInitial implements SmartLifecycle {

    @Autowired
    private StreamBridge streamBridge;

    @Override
    public void start() {
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sendExampleData1();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendExampleData1() throws IOException, TimeoutException {
        for (int i = 0; i < 10000; i++) {
//                ConnectionFactory factory = new ConnectionFactory();
//                factory.setHost("localhost");
//                Connection connection = factory.newConnection();
//                Channel channel = connection.createChannel();
//
//                String message = "product details";
//                channel.queueDeclare("topic37", false, false, false, null);
//
//                channel.basicPublish("", "topic37", null, message.getBytes());

            ObjectMapper objectMapper = new ObjectMapper();
            byte[] bytes = objectMapper.writeValueAsBytes(new ExampleData(i));
            streamBridge.send("sendExampleData1-out-0", bytes);

        }
        System.out.println("100 Veri Basıldı");
    }

    public void sendExampleData2() {
        for (int i = 0; i < 200; i++) {
            streamBridge.send("sendExampleData2-out-0", new ExampleData(i));
        }
        System.out.println("200 Veri Basıldı");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }


}
