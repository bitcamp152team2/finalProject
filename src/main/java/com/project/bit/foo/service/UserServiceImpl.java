package com.project.bit.foo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.bit.foo.domain.Users;
import com.project.bit.foo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserMapper userMapper;

	public UserServiceImpl() {
		
	}

	@Override
	public Users selectUserById(String USER_ID) {
		return userMapper.selectUserById(USER_ID);
	}

	@Override
	public void insertUser(Users user) {
		userMapper.insertUser(user);
		
	}

	@Override
	public List<Users> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public List<Users> selectUserByTeam(int teamCode) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByTeam(teamCode);
	}

	@Override
	public Users selectUser(String userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(userId);
	}

	@Override
	public void updateUser(Users user, String userId) {
		userMapper.updateUser(user, userId);
		
	}

	@Override
	public void updateUserPoto(Users user, String userId) {
		userMapper.updateUserPoto(user, userId);
		
	}

	@Override
	public void updateUserPw(Users user, String userId) {
		user.setUserPw(bCryptPasswordEncoder.encode(user.getUserPw()));
		userMapper.updateUserPw(user, userId);
		
	}

}
