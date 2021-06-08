package br.com.wa.http;

import br.com.wa.http.domain.request.UsersRequest;
import br.com.wa.http.domain.request.UserRequest;
import br.com.wa.http.domain.response.UserListResponse;
import br.com.wa.http.domain.response.UserResponse;

public interface UserWS {

	public UserResponse saveRegister(UserRequest request);
	
	public UserResponse saveRegisters(UsersRequest request);
	
	public UserListResponse listRegisters();
	
}
