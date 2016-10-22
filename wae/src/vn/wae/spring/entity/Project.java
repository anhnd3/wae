package vn.wae.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "title")
	String title;

	@Column(name = "thumbnail")
	String thumbnail;

	@Column(name = "short_desc")
	String shortDesc;

	@Column(name = "author")
	String author;

	@Column(name = "status")
	byte status;

	public Project() {
	}

	public Project(int id, String title, String thumbnail, String shortDesc, String author, byte status) {
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortDesc = shortDesc;
		this.author = author;
		this.status = status;
	}

	public Project(String title, String thumbnail, String shortDesc, String author, byte status) {
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortDesc = shortDesc;
		this.author = author;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", thumbnail=" + thumbnail + ", shortDesc=" + shortDesc
				+ ", author=" + author + ", status=" + status + "]";
	}
}
