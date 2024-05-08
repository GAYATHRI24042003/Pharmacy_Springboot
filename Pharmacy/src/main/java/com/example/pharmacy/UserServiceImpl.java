package com.example.pharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDataRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	public UserServiceImpl(UserDataRepository userRepository,ProductRepository productRepository) {
		super();
		this.userRepository = userRepository;
		this.productRepository=productRepository;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		UserData user=UserMapper.mapToUser(userDto);
		userRepository.save(user);
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public UserDto getUserById(Long userId) {
		UserData user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Student is not exist with the given Student ID :"+userId));
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserData> users=userRepository.findAll();		
		return users.stream().map((user)->UserMapper.mapToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(String mail, UserDto updatedUser) {
		UserData user=userRepository.findByemail(mail).orElseThrow(()-> new ResourceNotFoundException("Student is not exist with the given Student mail :"+mail));
		List<Product> products=new ArrayList<>();
		for(ProductDto m:updatedUser.getProducts()) {
			Product p=new Product(m.getId(),m.getPname(),m.getQuantity(),m.getPrice());
			p.setUserData(user);
			products.add(p);
		}
		user.setProducts(products);
		UserData upUser= userRepository.save(user);
		return UserMapper.mapToUserDto(upUser);
	}

	@Override
	public void deleteUser(Long userId) {
		UserData user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Student is not exist with the given Student ID :"+userId));
		userRepository.deleteById(userId);
		
	}

	@Override
	public UserDto findByemail(String email) {
		UserData user = userRepository.findByemail(email).orElseThrow(()->new ResourceNotFoundException("Email does not exit"));
		return UserMapper.mapToUserDto(user);
	}

}
