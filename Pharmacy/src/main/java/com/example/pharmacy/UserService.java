package com.example.pharmacy;

import java.util.List;


import com.example.pharmacy.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	UserDto getUserById(Long userId);
	List<UserDto> getAllUsers();
//	UserDto updateUser(Long userId,UserDto updatedUser);
	void deleteUser(Long userId);
	UserDto findByemail(String email);
	UserDto updateUser(String mail, UserDto updatedUser);
}
