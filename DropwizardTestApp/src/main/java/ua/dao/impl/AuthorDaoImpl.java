package ua.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dao.AuthorDao;
import ua.model.AuthorModel;

@Repository
public class AuthorDaoImpl implements AuthorDao{

	private final JdbcTemplate template;
	
	private final RowMapper<AuthorModel> mapper = (rs, rn)->new AuthorModel(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));

	public AuthorDaoImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(AuthorModel author) {
		template.update("INSERT INTO author(name, age) VALUES (?, ?)", author.getName(), author.getAge());
	}

	@Override
	public void update(AuthorModel author) {
		template.update("UPDATE author SET name=?, age=? WHERE id=?", author.getName(), author.getAge(), author.getId());
	}

	@Override
	public void delete(int id) {
		template.update("DELETE FROM author WHERE id=?", id);
	}

	@Override
	public List<AuthorModel> findAll() {
		return template.query("SELECT id, name, age FROM author", mapper);
	}

	@Override
	public AuthorModel findOne(int id) {
		try {
			return template.queryForObject("SELECT id, name, age FROM author WHERE id=?", new Object[]{id}, mapper);
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}