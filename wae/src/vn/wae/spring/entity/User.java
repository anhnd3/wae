package vn.wae.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "email")
	String email;

	@Column(name = "password")
	String password;

	@Column(name = "privilege")
	byte privilege;

	public User() {
	}

	public User(int id, String email, String password, byte privilege) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.privilege = privilege;
	}

	public User(String email, String password, byte privilege) {
		this.email = email;
		this.password = password;
		this.privilege = privilege;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getPrivilege() {
		return privilege;
	}

	public void setPrivilege(byte privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", privilege=" + privilege + "]";
	}
}
