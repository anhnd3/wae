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
public class GpsTrackingLocation implements Serializable {

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

	@Column(name = "`location`")
	String location;
	

	public GpsTrackingLocation() {
	}

	public GpsTrackingLocation(int id, int deviceId, Date time, String location) {
		this.id = id;
		this.deviceId = deviceId;
		this.time = time;
		this.location = location;
	}

	public GpsTrackingLocation(int deviceId, Date time, String location) {
		this.deviceId = deviceId;
		this.time = time;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "GpsTrackingLocation [id=" + id + ", deviceId=" + deviceId + ", time=" + time + ", location="
				+ location + "]";
	}
}
