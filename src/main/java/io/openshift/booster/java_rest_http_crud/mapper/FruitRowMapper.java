package io.openshift.booster.java_rest_http_crud.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.openshift.booster.java_rest_http_crud.entity.Fruit;

public class FruitRowMapper implements RowMapper<Fruit> {

	@Override
	public Fruit mapRow(ResultSet rs, int arg1) throws SQLException {
		Fruit theFruit = new Fruit();
		theFruit.setId(rs.getString("id"));
		theFruit.setName(rs.getString("name"));
		theFruit.setQuantity(rs.getString("quantity"));
 
        return theFruit;
	}

}
