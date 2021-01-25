package users.services;

import org.springframework.stereotype.Service;
import users.entities.userEntity;

@Service
public interface usersServices {
	Iterable<userEntity> getUsers();
	userEntity saveUser(userEntity userEntity);
	userEntity getUser(long id);
	userEntity putUser(long id, userEntity userEntity);
	String deleteUser(long id);
}
