package com.example.pharmacy;

import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {
	public static UserDto mapToUserDto(UserData userData) {
		UserDto st= new UserDto(userData.getId(),userData.getName(),userData.getEmail(),userData.getPassword());
		try {
		List<ProductDto> pDtos = userData.getProducts().stream()
	            .map((p)->ProductMapper.mapToProductDto(p))
	            .collect(Collectors.toList());

	    st.setProducts(pDtos);
		}
		catch(Exception e) {
			System.out.print("Null");
		}
		return st;
	}
	public static UserData mapToUser(UserDto userDto) {
		UserData st= new UserData(userDto.getId(),userDto.getName(),userDto.getEmail(),userDto.getPassword());
		try {
		List<Product> pro = userDto.getProducts().stream()
	            .map((p)->ProductMapper.mapToProduct(p))
	            .collect(Collectors.toList());

	    st.setProducts(pro);
		}
		catch(Exception e) {
			System.out.print("Null");
		}
		return st;
	}
}
