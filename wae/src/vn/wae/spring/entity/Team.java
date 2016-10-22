package vn.wae.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "name")
	String name;

	@Column(name = "avatar")
	String avatar;

	@Column(name = "title")
	String title;

	@Column(name = "short_desc")
	String shortDesc;

	@Column(name = "facebook")
	String facebook;

	@Column(name = "twitter")
	String twitter;

	@Column(name = "linkedin")
	String linkedIn;

	@Column(name = "google_plus")
	String googlePlus;

	@Column(name = "status")
	byte status;

	public Team() {
	}

	public Team(int id, String name, String avatar, String title, String shortDesc, String facebook, String twitter,
			String linkedIn, String googlePlus, byte status) {
		this.id = id;
		this.name = name;
		this.avatar = avatar;
		this.title = title;
		this.shortDesc = shortDesc;
		this.facebook = facebook;
		this.twitter = twitter;
		this.linkedIn = linkedIn;
		this.googlePlus = googlePlus;
		this.status = status;
	}

	public Team(String name, String avatar, String title, String shortDesc, String facebook, String twitter,
			String linkedIn, String googlePlus, byte status) {
		this.name = name;
		this.avatar = avatar;
		this.title = title;
		this.shortDesc = shortDesc;
		this.facebook = facebook;
		this.twitter = twitter;
		this.linkedIn = linkedIn;
		this.googlePlus = googlePlus;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getGooglePlus() {
		return googlePlus;
	}

	public void setGooglePlus(String googlePlus) {
		this.googlePlus = googlePlus;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", avatar=" + avatar + ", title=" + title + ", shortDesc="
				+ shortDesc + ", facebook=" + facebook + ", twitter=" + twitter + ", linkedIn=" + linkedIn
				+ ", googlePlus=" + googlePlus + ", status=" + status + "]";
	}
}
