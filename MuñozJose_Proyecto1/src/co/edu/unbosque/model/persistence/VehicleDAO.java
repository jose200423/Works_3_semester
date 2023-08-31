package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Objects;

import co.edu.unbosque.model.VehicleDTO;
import co.edu.unbosque.utiles.MyLInkedList;

public class VehicleDAO {

	private MyLInkedList<VehicleDTO> listv;

	public VehicleDAO() {
		try {
			if (!Objects.isNull(FileHandler.readSerialized("serializado.mjpu"))) {
				listv = cargarDesdeArchivo();
			} else {
				listv = new MyLInkedList<>();
			}
		} catch (Exception e) {
			listv = new MyLInkedList<>();
		}
	}

	public boolean create(VehicleDTO ve) {
		String newPlate = ve.getPlate();
		if (listv.size() >= 100) {
			return false;
		}

		for (int i = 0; i < listv.size(); i++) {
			String existingPlate = listv.get(i).getInfo().getPlate();
			if (existingPlate.equals(newPlate)) {
				return false;
			}
		}
		listv.addLast(ve);
		writePlates();
		guardarEnArchivo();
		return true;

	}

	public boolean eliminate(String p) {

		for (int i = 0; i < listv.size(); i++) {
			if (listv.get(i).getInfo().getPlate().equals(p)) {
				writeDeleted(listv.get(i).getInfo());
				listv.remove(i);
				writePlates();
				guardarEnArchivo();
				return true;
			}
		}
		return false;

	}

	public String show() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < listv.size(); i++) {
			buf.append(listv.get(i).getInfo().toString());
		}
		return buf.toString();
	}

	public void guardarEnArchivo() {
		FileHandler.writeSerialized("serializado.mjpu", listv);
	}

	public MyLInkedList<VehicleDTO> cargarDesdeArchivo() {
		return (MyLInkedList<VehicleDTO>) FileHandler.readSerialized("serializado.mjpu");
	}

	public MyLInkedList<VehicleDTO> getList() {
		return listv;
	}

	public void setList(MyLInkedList<VehicleDTO> list) {
		this.listv = list;
	}

	public void writePlates() {
		LocalTime timeCurrent = LocalTime.now();
		LocalDate dateCurrent = LocalDate.now();
		int hours = timeCurrent.getHour();
		int mins = timeCurrent.getMinute();
		int segs = timeCurrent.getSecond();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listv.size(); i++) {
			sb.append(listv.get(i).getInfo().getType()).append(" --> ");
			sb.append(listv.get(i).getInfo().getPlate()).append(" --> ");
			sb.append(hours).append(":").append(mins).append(":").append(segs).append(" --> ");
			sb.append(dateCurrent).toString();
			sb.append("\n");
		}

		FileHandler.writeFile("vehicles.txt", sb.toString());
	}

	public void writeDeleted(VehicleDTO v) {
		StringBuilder sb = new StringBuilder(FileHandler.readFile("salida.txt"));
		LocalTime timeCurrent = LocalTime.now();
		LocalDate dateCurrent = LocalDate.now();
		int hours = timeCurrent.getHour();
		int mins = timeCurrent.getMinute();
		int segs = timeCurrent.getSecond();
		sb.append(v.getType()).append(" --> ");
		sb.append(v.getPlate()).append(" --> ");
		sb.append(hours).append(":").append(mins).append(":").append(segs).append(" --> ");
		sb.append(dateCurrent).toString();
		sb.append("\n");
		FileHandler.writeFile("exit.txt", sb.toString());
	}

}
