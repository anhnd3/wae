package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.BlogCategory;

public interface BlogCategoryDAO {

	public int saveBlogCategory(BlogCategory category);

	public int deleteBlogCategory(int categoryId);

	public BlogCategory getBlogCategory(int categoryId);

	public List<BlogCategory> getBlogCategories(int pos, int limit);

	public List<BlogCategory> getBlogCategoriesByType(BlogType type, int pos, int limit);

}
