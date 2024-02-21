package com.hexaware.userrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.hexaware.userrest.dto.UserDTO;
import com.hexaware.userrest.entity.User;
import com.hexaware.userrest.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImp implements IUserService{


	@Autowired
	UserRepository repo;
	


	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}



	@Override
	public String deleteUserById(int uid) {
		repo.deleteById(uid);
		 return "Record Deleted";
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User addUser(UserDTO userDTO) {
		User user= new User(); 

		
		user.setAddress(userDTO.getAddress());
		user.setContactnumber(userDTO.getContactnumber());
		user.setGender(userDTO.getGender());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setUserid(userDTO.getUserid());
		user.setUsername(userDTO.getUsername());

		return repo.save(user);
	}



	@Override
	public UserDTO getUserById(int uid) {
		
		User user= repo.findById(uid).orElse(new User());
		
		/*
		 * if(product.getPid() == 0) {
		 * 
		 * throw new ProductNotFoundException(HttpStatus.NOT_FOUND ,
		 * "Product Not Found from Service");
		 * 
		 * }
		 */
		

		UserDTO userDTO = new UserDTO();

		userDTO.setAddress(user.getAddress());
		userDTO.setContactnumber(user.getContactnumber());
		userDTO.setGender(user.getGender());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setUserid(user.getUserid());
		userDTO.setUsername(user.getUsername());

		
		return  userDTO;
				
	}

}
