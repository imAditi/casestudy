package com.example.casestudyapp.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
// Do not use @service,@component,@Repository here, It is spring independent class

abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{

	@Autowired
	public void setDataSource2(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
}
