package ua.dao;

import java.util.List;

import ua.model.AuthorModel;

public interface AuthorDao {

	void save(AuthorModel author);
	
	void update(AuthorModel author);
	
	void delete(int id);
	
	List<AuthorModel> findAll();
	
	AuthorModel findOne(int id);
}
