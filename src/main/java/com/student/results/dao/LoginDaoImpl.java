package com.student.results.dao;

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
	public String validateLoginMember(Long id, String pwd) {

		if (id == 1 && pwd.equals("praveen")) {
			return "Admin login";
		} else {
			long ID;
			String PASSWORD;
			boolean validUser = false;
			String sql = "select id as id, password as pwd from student_register";
			List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);

			for (Map<String, Object> map : userList) {
				ID = (long) map.get("id");
				PASSWORD = (String) map.get("pwd");

				if (id == ID && pwd.equals(PASSWORD)) {
					validUser = true;
				}
			}

			if (validUser)
				return "Valid User";
			else
				return "Unauthorised User";
		}
	}

}
