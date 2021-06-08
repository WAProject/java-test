package br.com.wa.http.domain.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

	@NotNull
	private String street;
	
	@NotNull
	private String postalCode;
	
}
