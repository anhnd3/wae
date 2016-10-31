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
@Table(name = "blog")
public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6582436474041635461L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "`title`")
	@NotBlank(message = "Blog Title is not blank")
	String title;

	@Column(name = "`time`")
	long time;

	@Column(name = "`short_desc`")
	String shortDesc;

	@Column(name = "`full_desc`")
	String fullDesc;

	@Column(name = "`thumbnail`")
	@URL(message = "URL format fail")
	String thumbnail;

	@Column(name = "`full_image`")
	@URL(message = "URL format fail")
	String fullImage;

	@Column(name = "`highlight`", columnDefinition = "TINYINT(1)")
	boolean highlight;

	@Column(name = "`author`")
	String author;

	@Column(name = "`status`", columnDefinition = "TINYINT(1)")
	boolean status;

	@Column(name = "`views`")
	long views;

	@Column(name = "`categoryId`")
	int categoryId;

	public Blog() {
	}

	public Blog(String title, long time, String shortDesc, String fullDesc, String thumbnail, String fullImage,
			boolean highlight, String author, boolean status, long views, int categoryId) {
		this.title = title;
		this.time = time;
		this.shortDesc = shortDesc;
		this.fullDesc = fullDesc;
		this.thumbnail = thumbnail;
		this.fullImage = fullImage;
		this.highlight = highlight;
		this.author = author;
		this.status = status;
		this.views = views;
		this.categoryId = categoryId;
	}

	public Blog(int id, String title, long time, String shortDesc, String fullDesc, String thumbnail, String fullImage,
			boolean highlight, String author, boolean status, long views, int categoryId) {
		this.id = id;
		this.title = title;
		this.time = time;
		this.shortDesc = shortDesc;
		this.fullDesc = fullDesc;
		this.thumbnail = thumbnail;
		this.fullImage = fullImage;
		this.highlight = highlight;
		this.author = author;
		this.status = status;
		this.views = views;
		this.categoryId = categoryId;
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

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getFullDesc() {
		return fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getFullImage() {
		return fullImage;
	}

	public void setFullImage(String fullImage) {
		this.fullImage = fullImage;
	}

	public boolean getHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
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

	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", time=" + time + ", shortDesc=" + shortDesc + ", fullDesc="
				+ fullDesc + ", thumbnail=" + thumbnail + ", fullImage=" + fullImage + ", highlight=" + highlight
				+ ", author=" + author + ", status=" + status + ", views=" + views + ", categoryId=" + categoryId + "]";
	}

}
