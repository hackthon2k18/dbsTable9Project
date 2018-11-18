package com.student.results.dao;

import org.springframework.stereotype.Service;

@Service
public interface LoginDao {

	public String validateLoginMember(Long id, String pwd);

}
