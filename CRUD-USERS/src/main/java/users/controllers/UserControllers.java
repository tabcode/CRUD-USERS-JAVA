package users.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import users.entities.userEntity;
import users.services.usersServices;


@Controller
@RequestMapping
public class UserControllers {
	
	@Autowired
	usersServices usersServices;
	
    @GetMapping
    public ResponseEntity<Iterable<userEntity>> getUsers() {
    	Iterable<userEntity> userList = new ArrayList<>();
    	userList = usersServices.getUsers();
        return ResponseEntity.ok(userList);
    }
    
    @PostMapping
    public ResponseEntity<userEntity> postUser(@RequestBody userEntity userEntity) {
		return ResponseEntity.ok(usersServices.saveUser(userEntity));
    	
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<userEntity> getUser(@PathVariable long id) {
        return ResponseEntity.ok(usersServices.getUser(id));
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<userEntity> putUser(@PathVariable long id,@RequestBody userEntity userEntity) {
        return ResponseEntity.ok(usersServices.putUser(id,userEntity));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        return ResponseEntity.ok(usersServices.deleteUser(id));
    }
}
