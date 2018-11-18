package com.springboot.dbshackathon.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springboot.dbshackathon.common.CommonResponse;
import com.springboot.dbshackathon.common.StudentResponse;
import com.springboot.dbshackathon.model.Register;

@Service
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDaoImpl.class);

	@Override
	public CommonResponse insert(Register register) {
		CommonResponse response = null;

		Long userId = Long
				.valueOf(jdbcTemplate.queryForObject("select nextval('quickstart.sequence_id')", String.class));
		try {
			String sql = "insert into dbs_users(user_id,fullname,mobilenumber,email,password) values (?,?,?,?,?)";
			int rs = jdbcTemplate.update(sql, userId, register.getFullName(), register.getMobileNumber(),
					register.getEmail(), register.getPassword());

			if (rs > 0) {
				response = new CommonResponse();
				response.setId(userId);
				response.setResponse("Successfully added user");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	@Override
	public Register findById(Long sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponse findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse delete(Long sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponse update(Long sid, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

}
