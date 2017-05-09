package vn.wae.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "smart_garden_status")
public class SmartGardenStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -295020024321897009L;

	@Id
	@Column(name = "`id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "`time`")
	long time;

	@Column(name = "`temperature`")
	String temperature;

	@Column(name = "`air_humidity`")
	String airHumidity;

	@Column(name = "`ground_humidity`")
	String groundHumidity;

	@Column(name = "`drip_time`")
	int dripTime;

	@Column(name = "`drip_error`", columnDefinition = "TINYINT(1)")
	boolean isDripError;

	@Column(name = "`spray_time`")
	int sprayTime;

	@Column(name = "`spray_error`", columnDefinition = "TINYINT(1)")
	boolean isSprayError;

	public SmartGardenStatus() {
	}

	public SmartGardenStatus(long id, long time, String temperature, String airHumidity, String groundHumidity,
			int droppingsTime, boolean isDroppingsError, int sprayTime, boolean isSprayError) {
		super();
		this.id = id;
		this.time = time;
		this.temperature = temperature;
		this.airHumidity = airHumidity;
		this.groundHumidity = groundHumidity;
		this.dripTime = droppingsTime;
		this.isDripError = isDroppingsError;
		this.sprayTime = sprayTime;
		this.isSprayError = isSprayError;
	}

	public SmartGardenStatus(long time, String temperature, String airHumidity, String groundHumidity,
			int droppingsTime, boolean isDroppingsError, int sprayTime, boolean isSprayError) {
		super();
		this.time = time;
		this.temperature = temperature;
		this.airHumidity = airHumidity;
		this.groundHumidity = groundHumidity;
		this.dripTime = droppingsTime;
		this.isDripError = isDroppingsError;
		this.sprayTime = sprayTime;
		this.isSprayError = isSprayError;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getAirHumidity() {
		return airHumidity;
	}

	public void setAirHumidity(String airHumidity) {
		this.airHumidity = airHumidity;
	}

	public String getGroundHumidity() {
		return groundHumidity;
	}

	public void setGroundHumidity(String groundHumidity) {
		this.groundHumidity = groundHumidity;
	}

	public int getDroppingsTime() {
		return dripTime;
	}

	public void setDroppingsTime(int droppingsTime) {
		this.dripTime = droppingsTime;
	}

	public boolean isDroppingsError() {
		return isDripError;
	}

	public void setDroppingsError(boolean isDroppingsError) {
		this.isDripError = isDroppingsError;
	}

	public int getSprayTime() {
		return sprayTime;
	}

	public void setSprayTime(int sprayTime) {
		this.sprayTime = sprayTime;
	}

	public boolean isSprayError() {
		return isSprayError;
	}

	public void setSprayError(boolean isSprayError) {
		this.isSprayError = isSprayError;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SmartGardenStatus [id=" + id + ", time=" + time + ", temperature=" + temperature + ", airHumidity="
				+ airHumidity + ", groundHumidity=" + groundHumidity + ", dripTime=" + dripTime + ", isDripError="
				+ isDripError + ", sprayTime=" + sprayTime + ", isSprayError=" + isSprayError + "]";
	}

}
