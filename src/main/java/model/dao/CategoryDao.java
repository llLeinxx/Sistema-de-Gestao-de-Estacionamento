package model.dao;

import model.entities.Category;

public interface CategoryDao {
    Category findByCd (int cdCategory);
}
