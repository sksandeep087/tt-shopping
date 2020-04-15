package com.techtree.shoppingbacken.dao;

import java.util.List;

import com.techtree.shoppingbacken.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);

}
