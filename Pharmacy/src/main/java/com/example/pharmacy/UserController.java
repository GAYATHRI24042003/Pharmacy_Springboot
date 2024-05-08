package com.example.pharmacy;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto savedUser=userService.createUser(userDto);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
		UserDto userDto=userService.getUserById(userId);
		return ResponseEntity.ok(userDto);
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> findByemail(@PathVariable("email") String email){
		UserDto userDto=userService.findByemail(email);
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping 
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users=userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@PutMapping("{email}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("email") String mail,@RequestBody UserDto userDto){
		UserDto upUserDto=userService.updateUser(mail, userDto);
		return ResponseEntity.ok(upUserDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok("Student deleted Successfully!.. ");
	}
}

