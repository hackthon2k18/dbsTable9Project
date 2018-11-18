package com.student.results.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.results.common.SingleResponse;
import com.student.results.common.UriConstants;
import com.student.results.model.Login;
import com.student.results.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "login-api", description = "Login")
@RequestMapping(value = "/studentResult")
@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	SingleResponse singleResponse = new SingleResponse();

	public static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@ApiOperation(value = "User Login Verify", position = 1)
	@ApiResponse(code = 200, message = "Successfully Verified the User")
	@RequestMapping(value = UriConstants.LOGIN, method = RequestMethod.POST)
	public ResponseEntity<SingleResponse> login(@RequestBody @Valid Login request) {
		try {
			String str = loginService.validateLoginMember(request.getId(), request.getPassword());
			singleResponse.setResponse(str);
			return new ResponseEntity<SingleResponse>(singleResponse, HttpStatus.OK);
		} catch (Exception exception) {
			return null;
		}

	}
}