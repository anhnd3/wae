package vn.wae.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2694593358757525015L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "`name`")
	String name;

	@Column(name = "`thumbnail`")
	@NotBlank(message = "Thumbnail is not blank")
	@URL(message = "URL format fail")
	String thumbnail;

	@Column(name = "`short_desc`")
	String shortDesc;

	@Column(name = "`author`")
	String author;

	@Column(name = "`status`", columnDefinition = "TINYINT(1)")
	boolean status;

	@Column(name = "`highlight`", columnDefinition = "TINYINT(1)")
	boolean highlight;

	public Project() {
	}

	public Project(int id, String name, String thumbnail, String shortDesc, String author, boolean status,
			boolean highlight) {
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
		this.shortDesc = shortDesc;
		this.author = author;
		this.status = status;
		this.highlight = highlight;
	}

	public Project(String name, String thumbnail, String shortDesc, String author, boolean status, boolean highlight) {
		this.name = name;
		this.thumbnail = thumbnail;
		this.shortDesc = shortDesc;
		this.author = author;
		this.status = status;
		this.highlight = highlight;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", thumbnail=" + thumbnail + ", shortDesc=" + shortDesc
				+ ", author=" + author + ", status=" + status + ", highlight=" + highlight + "]";
	}
}
