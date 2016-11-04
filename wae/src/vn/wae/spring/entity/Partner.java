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
@Table(name = "partner")
public class Partner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6944758506022195879L;

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

	@Column(name = "`target_link`")
	@URL(message = "URL format fail")
	String targetLink;

	@Column(name = "`short_desc`")
	String shortDesc;

	@Column(name = "`status`", columnDefinition = "TINYINT(1)")
	boolean status;

	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partner(int id, String name, String thumbnail, String targetLink, String shortDesc, boolean status) {
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
		this.targetLink = targetLink;
		this.shortDesc = shortDesc;
		this.status = status;
	}

	public Partner(String name, String thumbnail, String targetLink, String shortDesc, boolean status) {
		this.name = name;
		this.thumbnail = thumbnail;
		this.targetLink = targetLink;
		this.shortDesc = shortDesc;
		this.status = status;
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTargetLink() {
		return targetLink;
	}

	public void setTargetLink(String targetLink) {
		this.targetLink = targetLink;
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", name=" + name + ", thumbnail=" + thumbnail + ", targetLink=" + targetLink
				+ ", shortDesc=" + shortDesc + ", status=" + status + "]";
	}
}