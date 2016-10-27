package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.BlogCategory;

public interface BlogCategoryDAO {

	public int saveCategory(BlogCategory category);

	public int deleteCategory(int categoryId);

	public BlogCategory getCategory(int categoryId);

	public List<BlogCategory> getCategorys(int pos, int limit);

}
