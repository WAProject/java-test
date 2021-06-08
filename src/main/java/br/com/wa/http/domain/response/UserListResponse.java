package br.com.wa.http.domain.response;

import java.util.List;

import br.com.wa.domain.user.User;
import lombok.Getter;
import lombok.Setter;

public class UserListResponse extends DefaultResponse {

	public UserListResponse(List<User> userList) {
		this.userList = userList;
	}
	
	@Getter @Setter
	private List<User> userList;
	

}
