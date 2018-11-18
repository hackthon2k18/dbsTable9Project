package com.springboot.dbshackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dbshackathon.common.CommonResponse;
import com.springboot.dbshackathon.common.UriConstants;
import com.springboot.dbshackathon.model.Register;
import com.springboot.dbshackathon.service.RegisterService;
import com.wordnik.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "UserRegistration", description = "Register APIs")
@RestController
@RequestMapping(value = "/" + UriConstants.REGISTER)
public class RegisterController {

	@Autowired
	RegisterService service;

	@ApiOperation(value = "Register User", position = 1)
	@ApiResponse(code = 200, message = "Successfully added User")
	@RequestMapping(value = UriConstants.INSERT, method = RequestMethod.POST)
	public CommonResponse addUser(@RequestBody Register user) {
		CommonResponse response = null;
		try {
			response = service.insert(user);
			System.out.println(response);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return response;

	}

	@ApiOperation(value = "find User by Id", position = 2)
	@ApiResponse(code = 200, message = "Successfully find User by Id")
	@RequestMapping(value = UriConstants.FINDBYID + "/{UserId}", method = RequestMethod.GET)
	public Register getUser(@PathVariable(value = "UserId") Long UserId) {
		Register User = null;
		try {
			User = new Register();
			User = service.findById(UserId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return User;

	}

	// @ApiOperation(value = "findAll Users", position = 3)
	// @ApiResponse(code = 200, message = "Successfully find All Users ")
	// @RequestMapping(value = UriConstants.FINDALL, method = RequestMethod.GET)
	// public ResponseEntity<UserResponse> getUsers() {
	// UserResponse response = null;
	// try {
	// response = service.findAll();
	// return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	// } catch (Exception exception) {
	// LOGGER.error("Find AllUsers request handled Successfully" +
	// exception.getMessage());
	// exception.printStackTrace();
	// return null;
	// }
	//
	// }

	@ApiOperation(value = "update User by Id", position = 4)
	@ApiResponse(code = 200, message = "Successfully updated User by Id")
	@RequestMapping(value = UriConstants.UPDATE + "/{UserId}", method = RequestMethod.PUT)
	public CommonResponse updateUser(@PathVariable(value = "UserId") Long UserId, @RequestBody Register User) {
		CommonResponse response = null;
		System.out.println("i am in controller");
		try {
			response = service.update(UserId, User);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return response;

	}

	@ApiOperation(value = "delete User by Id", position = 5)
	@ApiResponse(code = 200, message = "Successfully deleted User by Id")
	@RequestMapping(value = UriConstants.DELETE + "/{UserId}", method = RequestMethod.DELETE)
	public CommonResponse deleteUser(@PathVariable(value = "UserId") Long UserId) {
		CommonResponse response = null;
		try {
			response = service.delete(UserId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return response;

	}
}