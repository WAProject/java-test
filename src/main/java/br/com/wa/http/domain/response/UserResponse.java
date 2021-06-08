package br.com.wa.http.domain.response;

import br.com.wa.domain.user.User;
import lombok.Getter;
import lombok.Setter;

public class UserResponse extends DefaultResponse {
	
	public UserResponse(User user) {
		this.user = user;
	}
	
	@Getter @Setter
	private User user;

}
