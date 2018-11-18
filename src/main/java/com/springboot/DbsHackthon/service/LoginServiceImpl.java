package com.springboot.DbsHackthon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.DbsHackthon.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public String validateLoginMember(Long id, String pwd) {

		return loginDao.validateLoginMember(id, pwd);
	}

}
