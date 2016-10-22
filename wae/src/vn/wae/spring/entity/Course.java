package vn.wae.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "title")
	String title;

	@Column(name = "thumbnail")
	String thumbnail;

	@Column(name = "desc")
	String desc;

	@Column(name = "teacher")
	String teacher;

	@Column(name = "status")
	byte status;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String title, String thumbnail, String desc, String teacher, byte status) {
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.desc = desc;
		this.teacher = teacher;
		this.status = status;
	}

	public Course(String title, String thumbnail, String desc, String teacher, byte status) {
		this.title = title;
		this.thumbnail = thumbnail;
		this.desc = desc;
		this.teacher = teacher;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", thumbnail=" + thumbnail + ", desc=" + desc + ", teacher="
				+ teacher + ", status=" + status + "]";
	}
}
