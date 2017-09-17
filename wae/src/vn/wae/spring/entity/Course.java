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
@Table(name = "course")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -212819144150214492L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "`title`")
	@NotBlank(message = "Course name is not blank")
	String title;

	@Column(name = "`thumbnail`")
	@NotBlank(message = "Thumbnail is not blank")
	@URL(message = "URL format fail")
	String thumbnail;

	@Column(name = "`desc`")
	@NotBlank(message = "Short description is not blank")
	String desc;

	@Column(name = "`full_desc`")
	@NotBlank(message = "Full description is not blank")
	String fullDesc;

	@Column(name = "`teacher`")
	String teacher;

	@Column(name = "`status`", columnDefinition = "TINYINT(1)")
	boolean status;

	public Course() {
	}

	public Course(int id, String title, String thumbnail, String desc, String fullDesc, String teacher,
			boolean status) {
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.desc = desc;
		this.fullDesc = fullDesc;
		this.teacher = teacher;
		this.status = status;
	}

	public Course(String title, String thumbnail, String desc, String fullDesc, String teacher, boolean status) {
		this.title = title;
		this.thumbnail = thumbnail;
		this.desc = desc;
		this.fullDesc = fullDesc;
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

	public String getFullDesc() {
		return fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", thumbnail=" + thumbnail + ", desc=" + desc + ", fullDesc="
				+ fullDesc + ", teacher=" + teacher + ", status=" + status + "]";
	}
}
