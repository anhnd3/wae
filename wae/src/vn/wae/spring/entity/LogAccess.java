package vn.wae.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "log_access")
public class LogAccess implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1603831367325613420L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "`url`")
	String url;

	@Column(name = "`access`")
	@Version
	long access;

	public LogAccess() {
	}

	public LogAccess(int id, String url, long access) {
		this.id = id;
		this.url = url;
		this.access = access;
	}

	public LogAccess(String url, long access) {
		this.url = url;
		this.access = access;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getAccess() {
		return access;
	}

	public void setAccess(long access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "LogAccess [id=" + id + ", url=" + url + ", access=" + access + "]";
	}
}
