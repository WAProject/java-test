package br.com.wa.amqp.domain;

import java.util.List;

import br.com.wa.http.domain.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAmqpMessage {
	
	private List<UserRequest> registers;

}
