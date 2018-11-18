package com.springboot.dbshackathon.dao;

import org.springframework.stereotype.Service;

@Service
public interface LoginDao {

	public String validateLoginMember(String email, String pwd);

}
