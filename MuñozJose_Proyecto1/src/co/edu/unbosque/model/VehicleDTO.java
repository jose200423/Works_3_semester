package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalTime;

public class VehicleDTO implements Serializable {

	private static final long serialVersionUID = 3498085372505045103L;
	private String plate;
	private String type;
	private LocalTime timeCurrent;

	public VehicleDTO() {

	}

	public VehicleDTO(String type, String plate) {
		super();
		this.type = type;
		this.plate = plate;

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
		sb.append("Placa: ").append(plate).append("\n");
		return sb.toString();
	}

}
