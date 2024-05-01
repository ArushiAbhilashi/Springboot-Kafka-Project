package org.kafka.producer.wikimedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;

@SpringBootApplication
public class SpringbootProducerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootProducerApplication.class, args);
    }
    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;
    
    @Override
    public void run(String...args) throws Exception{
    	wikimediaChangesProducer.sendMessage();
    }
    
}