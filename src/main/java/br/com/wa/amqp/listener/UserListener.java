package br.com.wa.amqp.listener;

import br.com.wa.amqp.domain.UserAmqpMessage;

public interface UserListener {
	
	void consumeMessage(UserAmqpMessage message);

}
