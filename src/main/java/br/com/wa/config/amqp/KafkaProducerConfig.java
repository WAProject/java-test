package br.com.wa.config.amqp;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import br.com.wa.amqp.domain.UserAmqpMessage;

@Configuration
public class KafkaProducerConfig {

	@Value(value = "${spring.kafka.url}")
	private String kafkaAddress;

	@Bean
	public KafkaTemplate<String, UserAmqpMessage> registerKafkaTemplate() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		ProducerFactory<String, UserAmqpMessage> registerProducerFactory = new DefaultKafkaProducerFactory<>(configProps);
		return new KafkaTemplate<>(registerProducerFactory);
	}

}
