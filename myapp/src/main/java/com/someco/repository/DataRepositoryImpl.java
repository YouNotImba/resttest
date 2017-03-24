package com.someco.repository;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.someco.entity.Data;

/**
 * @author ikarmatsky
 *
 */
@Repository("dataRepository")
public class DataRepositoryImpl implements DataRepository<Data> {

	@Autowired
	private JdbcOperations jdbcOperations;

	public JdbcOperations getJdbcOperations() {
		return jdbcOperations;
	}

	public void setJdbcOperations(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public void persist(Data entity) {
		Object[] params = { entity.getId(), entity.getDescription() };
		int[] types = { Types.VARCHAR, Types.VARCHAR };

		jdbcOperations.update("INSERT into yourapp_data (data_id , data_description) VALUES (cast(? as UUID), ?);",
				params, types);
	}

	@Override
	public void delete(Data entity) {
		jdbcOperations.update("DELETE FROM yourapp_data WHERE data_id = " + entity.getId().toString() + ";");
	}

	@Override
	public Set<String> getRandomData() {
		Set<String> result = new HashSet<>();
		SqlRowSet rowSet = jdbcOperations
				.queryForRowSet("SELECT data_description FROM yourapp_data ORDER BY RANDOM() LIMIT 10;");
		while (rowSet.next()) {
			result.add(rowSet.getString("data_description"));
		}
		return result;
	}

}
