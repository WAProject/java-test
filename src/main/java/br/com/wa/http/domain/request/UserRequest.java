package br.com.wa.http.domain.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	@NotNull
	private String name;
	
	private String email;
	
	@NotNull
	private int age;
	
	private AddressRequest address;
	
}
