package vn.wae.spring.dao;

import java.util.List;

import vn.wae.spring.entity.Blog;

public interface BlogDAO {

	public int saveBlog(Blog blog);

	public int deleteBlog(int blogId);

	public Blog getBlog(int blogId);

	public List<Blog> getBlogs(int pos, int limit);

	public List<Blog> getBlogsHighLight(int pos, int limit, byte highlight);

	public List<Blog> getBlogsByCategory(int pos, int limit, int categoryId);
}