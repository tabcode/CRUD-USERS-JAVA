  package users.services.implementation;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import users.services.usersServices;
import users.crud.usersCrud;
import users.entities.userEntity;

@Service
public class UserServiceImp implements usersServices {
    @Autowired
    usersCrud usersCrud;
    
    @Override
    public Iterable<userEntity> getUsers() {
        Iterable<userEntity> returnValue = new ArrayList<>();
        returnValue = usersCrud.findAll();
        return returnValue;
    }

	@Override
	public userEntity saveUser(userEntity newUser) {
		return usersCrud.save(newUser);
	}

	@Override
	public userEntity getUser(long id) {
		Optional<userEntity> userEntity = usersCrud.findById(id);
		return userEntity.get();
	}

	@Override
	public userEntity putUser(long id, userEntity userEntity) {
		Optional<userEntity> oldUser = usersCrud.findById(id);
		userEntity newUser = oldUser.get();
		newUser.setUsername(userEntity.getUsername());
		return usersCrud.save(newUser);
	}

	@Override
	public String deleteUser(long id) {
		usersCrud.deleteById(id);
		return "User deleted";
	}
    
}
