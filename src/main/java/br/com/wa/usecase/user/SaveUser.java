package br.com.wa.usecase.user;

import br.com.wa.domain.user.DataBaseSequence;
import br.com.wa.http.domain.request.UserRequest;
import br.com.wa.http.domain.response.UserResponse;

public interface SaveUser {
    
    UserResponse execute(UserRequest request);
    
    DataBaseSequence findNextSequence(String sequenceName);

}
