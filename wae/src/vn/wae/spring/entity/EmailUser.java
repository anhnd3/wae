package vn.wae.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "email")
public class EmailUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1735144915994144883L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "`email`")
	@NotBlank(message = "Email is not blank")
	@Email(message = "Email format fail")
	String email;

	public EmailUser() {
	}

	public EmailUser(int id, String email) {
		this.id = id;
		this.email = email;
	}

	public EmailUser(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailUser [id=" + id + ", email=" + email + "]";
	}
}
