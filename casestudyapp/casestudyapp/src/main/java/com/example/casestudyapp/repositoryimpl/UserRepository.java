package com.example.casestudyapp.repositoryimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.casestudyapp.domain.User;
import com.example.casestudyapp.repository.BaseDAO;
import com.example.casestudyapp.rowmapper.UserRowMapper;

@Repository
public class UserRepository extends BaseDAO {


	public User save(User user) {
		String sql = "Insert into users(name,email) values(:name,:email)";
		Map<String, Object> params = new HashMap<>();
		params.put("name", user.getName());
		params.put("email", user.getEmail());
		SqlParameterSource paramSource = new MapSqlParameterSource(params);
		KeyHolder kh =  new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, paramSource,kh);
		user.setId(kh.getKey().intValue());
		
		return user;
	}


	public User update(User user) {
		String sql = "Update users set name=:name,email=:email where id=:id";
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", user.getName());
		params.put("email", user.getEmail());
		params.put("id", user.getId());
		SqlParameterSource sps = new MapSqlParameterSource(params);
		getNamedParameterJdbcTemplate().update(sql, sps);
		
		return user;
	}


	public int delete(int id) {
		String sql = "Delete from users where id=?";
		getJdbcTemplate().update(sql, id);
		return id;
	}

	public User getUser(int id) {
		String sql = "select * from users where id=?";
		
		User user = getJdbcTemplate().queryForObject(sql,new UserRowMapper(),id);
		
		return user;
		
	}


	public List<User> listOfUsers() {
		String sql = "Select * from users";
		
		List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
		for (User user : users) {
			
			System.out.println("User"+ user.getName());
	
		
		}
		return users;
	}
}
