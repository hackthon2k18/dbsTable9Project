package com.student.results.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	public String validateLoginMember(Long id, String pwd);

}
