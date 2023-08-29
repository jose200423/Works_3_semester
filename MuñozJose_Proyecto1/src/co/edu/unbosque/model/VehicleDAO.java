package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Objects;

import co.edu.unbosque.model.persistence.FileHandler;

public class VehicleDAO {

	private MyLInkedList<VehicleDTO> listv;

	public VehicleDAO() {
		try {
			if (!Objects.isNull(FileHandler.leerSerializado("serializado.mjpu"))) {
				listv = cargarDesdeArchivo();
			} else {
				listv = new MyLInkedList<>();
			}
		} catch (Exception e) {
			listv = new MyLInkedList<>();
		}
	}

	public boolean crear(VehicleDTO ve) {
		String nuevaPlaca = ve.getPlate();
		if(listv.size() >= 100) {
			return false;
		}

		for (int i = 0; i < listv.size(); i++) {
			String placaExistente = listv.get(i).getInfo().getPlate();
			if (placaExistente.equals(nuevaPlaca)) {
				return false;
			}
		}
		listv.addLast(ve);
		escribirPlacas();
		guardarEnArchivo();
		return true;

	}

	public boolean eliminar(String p) {

		for (int i = 0; i < listv.size(); i++) {
			if (listv.get(i).getInfo().getPlate().equals(p)) {
				escribirEliminados(i);
				listv.remove(i);
				escribirPlacas();
				guardarEnArchivo();
				return true;
			}
		}
		return false;

	}

	public String mostrar() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < listv.size(); i++) {
			buf.append(listv.get(i).getInfo().toString());
		}
		return buf.toString();
	}

	public void guardarEnArchivo() {
		FileHandler.escribirSerializado("serializado.mjpu", listv);
	}

	public MyLInkedList<VehicleDTO> cargarDesdeArchivo() {
		return (MyLInkedList<VehicleDTO>) FileHandler.leerSerializado("serializado.mjpu");
	}

	public MyLInkedList<VehicleDTO> getList() {
		return listv;
	}

	public void setList(MyLInkedList<VehicleDTO> list) {
		this.listv = list;
	}

	public void escribirPlacas() {
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

		FileHandler.escribirArchivo("Cars.txt", sb.toString());
	}

	public void escribirEliminados(int remove) {
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

		FileHandler.escribirArchivo("salida.txt", sb.toString());
	}
	
	

}
