package com.springboot.dbshackathon.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	public String validateLoginMember(String email, String pwd);

}
