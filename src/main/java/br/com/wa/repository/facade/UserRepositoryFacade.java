package br.com.wa.repository.facade;

import java.util.List;

import br.com.wa.domain.user.User;

public interface UserRepositoryFacade {

	public User save(User user);
	
	public List<User> findAll();
	
}
