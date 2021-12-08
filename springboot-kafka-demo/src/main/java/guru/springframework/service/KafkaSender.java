package guru.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "sample_topic_spring_boot_with_kafka";
	
	public void send(String data) {
	    
	    kafkaTemplate.send(kafkaTopic, data);
	}
}