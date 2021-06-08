package br.com.wa.domain.conveter;

import br.com.wa.domain.user.Address;
import br.com.wa.domain.user.User;
import br.com.wa.http.domain.request.UserRequest;

public class UserConverter {
	
	public static User convertFromRequest(UserRequest request, int id) {
		User user = new User();
		user.setId(id);
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setAge(request.getAge());
		
		if(request.getAddress() != null) {
			user.setAddress(new Address(request.getAddress().getStreet(), request.getAddress().getPostalCode()));
		}
		
		return user;
	}

}
