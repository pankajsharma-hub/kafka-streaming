package streamed_files;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Kafka_producer {
	
	public static void main(String args[]) {
		
		String bootstrapServers="127.0.0.1:9092";
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		// Creating Kafka Producer
		KafkaProducer<String,String> first_producer = new KafkaProducer<String,String>(properties);
		
		ProducerRecord<String,String> record = new ProducerRecord<String,String>("first-topic","Hello from java maven");
		first_producer.send(record);
		first_producer.flush();
		first_producer.close();
		
	}

}
 