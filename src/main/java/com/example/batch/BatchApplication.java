package com.example.batch;

import com.example.batch.producer.stream.ExampleService;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.Executors;

@SpringBootApplication
public class BatchApplication extends Application {

    @Autowired
    private ConfigurableApplicationContext applicationContext;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ExampleService exampleService = new ExampleService();
        Executors.newSingleThreadExecutor().execute(exampleService);
    }

    @Override
    public void init() {
        applicationContext = SpringApplication.run(BatchApplication.class, "");
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }
}
