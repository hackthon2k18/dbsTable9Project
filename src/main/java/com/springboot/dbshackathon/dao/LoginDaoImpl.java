package com.springboot.dbshackathon.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginDaoImpl implements LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String validateLoginMember(String email, String pwd) {

		if (email.equals("praveen@gmail.com") && pwd.equals("999")) {
			return "Admin login";
		} else {

			String sql = "select * from dbs_users where email = ? and password = ?";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, email, pwd);

			System.out.println(rows.size());
			if (rows.size() > 0) {
				return "Valid User";
			} else {
				return "UnAuthorised user";
			}
		}
	}

}
