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

	public VehicleDTO() {

	}

	public VehicleDTO(String type, String plate, LocalTime timeCurrent) {
		super();
		this.type = type;
		this.plate = plate;
		this.timeCurrent = LocalTime.now();
		this.amPm = this.timeCurrent.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
		

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
		sb.append("Time: ").append(timeCurrent).append(amPm).append("\n");
		return sb.toString();
	}

}
