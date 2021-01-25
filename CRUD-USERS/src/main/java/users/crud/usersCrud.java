package users.crud;

import org.springframework.data.repository.CrudRepository;

import users.entities.userEntity;

public interface usersCrud extends CrudRepository<userEntity, Long> {
}
