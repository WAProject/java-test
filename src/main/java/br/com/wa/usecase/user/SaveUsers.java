package br.com.wa.usecase.user;

import br.com.wa.http.domain.request.UsersRequest;
import br.com.wa.http.domain.response.UserResponse;

public interface SaveUsers {
    
    UserResponse execute(UsersRequest request); 	

}
