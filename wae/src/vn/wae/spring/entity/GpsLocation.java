package vn.wae.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gps_tracking_location")
public class GpsLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4599630407822495823L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "`device_id`")
	int deviceId;

	@Column(name = "`time`", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	Date time;

	@Column(name = "`longtitude`")
	String longtitude;

	@Column(name = "`latitude`")
	String latitude;

	@Column(name = "`address`")
	String address;

	public GpsLocation() {
	}

	public GpsLocation(long id, int deviceId, Date time, String longtitude, String latitude, String address) {
		this.id = id;
		this.deviceId = deviceId;
		this.time = time;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.address = address;
	}

	public GpsLocation(int deviceId, Date time, String longtitude, String latitude, String address) {
		this.deviceId = deviceId;
		this.time = time;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "GpsTrackingLocation [id=" + id + ", deviceId=" + deviceId + ", time=" + time + ", longtitude="
				+ longtitude + ", latitude=" + latitude + ", address=" + address + "]";
	}
}
