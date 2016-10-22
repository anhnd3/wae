package vn.wae.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partner")
public class Partner {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "name")
	String name;

	@Column(name = "thumbnail")
	String thumbnail;

	@Column(name = "short_desc")
	String shortDesc;

	@Column(name = "status")
	byte status;

	public Partner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partner(int id, String name, String thumbnail, String shortDesc, byte status) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
		this.shortDesc = shortDesc;
		this.status = status;
	}

	public Partner(String name, String thumbnail, String shortDesc, byte status) {
		super();
		this.name = name;
		this.thumbnail = thumbnail;
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

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", name=" + name + ", thumbnail=" + thumbnail + ", shortDesc=" + shortDesc
				+ ", status=" + status + "]";
	}
}