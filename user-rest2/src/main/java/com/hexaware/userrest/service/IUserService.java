package com.hexaware.userrest.service;

import java.util.List;

import com.hexaware.userrest.dto.UserDTO;
import com.hexaware.userrest.entity.User;


public interface IUserService {

	public User addUser(UserDTO userDTO);

	public User updateUser(User User);

	public UserDTO getUserById(int eid);

	public String deleteUserById(int eid);
	
	public  List<User>  getAllUsers();


	
}
