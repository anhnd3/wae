package vn.wae.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "blog_category")
public class BlogCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4691560022513239619L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "`name`")
	@NotBlank(message = "Blog Category is not blank")
	String name;

	@Column(name = "`status`", columnDefinition = "TINYINT(1)")
	boolean status;

	@Column(name = "`type`")
	int type;

	@Transient
	int totalBlog;

	public BlogCategory() {
	}

	public BlogCategory(int id, String name, boolean status, int type) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.type = type;
	}

	public BlogCategory(String name, boolean status, int type) {
		this.name = name;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTotalBlog() {
		return totalBlog;
	}

	public void setTotalBlog(int totalBlog) {
		this.totalBlog = totalBlog;
	}

	@Override
	public String toString() {
		return "BlogCategory [id=" + id + ", name=" + name + ", status=" + status + ", type=" + type + ", totalBlog="
				+ totalBlog + "]";
	}
}
