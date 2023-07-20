package com.make.assure.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.make.assure.models.ResponseData;
import com.make.assure.models.UserInfo;
import com.make.assure.services.UserInfoService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/user")
public class UserInfoController {

	@Autowired
	UserInfoService userService;
	
	@PostMapping("/")
	public ResponseEntity<ResponseData<UserInfo>>saveUser(@RequestBody UserInfo user)
	{
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseData<Optional<UserInfo>>>fetchUserById(@PathVariable int id)
	{
		return new ResponseEntity<>(userService.fetchUserById(id),HttpStatus.OK);
	}
	
}
