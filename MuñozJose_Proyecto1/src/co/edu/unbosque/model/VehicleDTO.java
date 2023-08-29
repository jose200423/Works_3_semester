package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class VehicleDTO implements Serializable {

	private static final long serialVersionUID = 3498085372505045103L;
	private String plate;
	private String type;
	private LocalTime timeCurrent;
	private String amPm;
	private int hours;
	private int mins;
	private int segs;

	public VehicleDTO() {

	}

	public VehicleDTO(String type, String plate, LocalTime timeCurrent) {
		super();
		this.type = type;
		this.plate = plate;
		this.timeCurrent = LocalTime.now();
		hours = timeCurrent.getHour();
		mins = timeCurrent.getMinute();
		segs = timeCurrent.getSecond();

	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}

	public int getSegs() {
		return segs;
	}

	public void setSegs(int segs) {
		this.segs = segs;
	}

	public String getAmPm() {
		return amPm;
	}

	public void setAmPm(String amPm) {
		this.amPm = amPm;
	}

	public LocalTime getTimeCurrent() {
		return timeCurrent;
	}

	public void setTimeCurrent(LocalTime timeCurrent) {
		this.timeCurrent = timeCurrent;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tipo: ").append(type).append(" --> ");
		sb.append("Placa: ").append(plate).append(" --> ");
		sb.append("Time: ").append(hours).append(":").append(mins).append(":").append(segs).append("\n");
		return sb.toString();
	}

}
