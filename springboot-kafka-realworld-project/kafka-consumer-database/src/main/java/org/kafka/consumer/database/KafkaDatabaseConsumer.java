package org.kafka.consumer.database;

import java.util.logging.Logger;

import org.kafka.consumer.database.repository.WikimediaDataRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
   
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	private WikimediaDataRepository dataRepository;
	
	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		this.dataRepository=dataRepository;
	}
	
	@KafkaListener(topics="wikimedia_recentChange" groupId="myGroup")
	public void consumer(String eventMessage) {
		LOGGER.info(String.format("Event Message Received -> %s", eventMessage));
		WikimediaData wikimediaData=new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		dataRepository.save(wikimediaData);
		
	}
}