package br.com.wa.config.amqp;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wa.amqp.domain.KafkaConstants;

@Configuration
public class KafkaTopicConfig {

	@Value(value = "${spring.kafka.url}")
	private String kafkaAddress;

    @Bean
    public NewTopic topic() {
        return new NewTopic(KafkaConstants.TOPIC_REGISTER, 1, (short) 1);
    }
}
