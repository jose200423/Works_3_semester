package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Scanner;

import co.edu.unbosque.model.VehicleDTO;
import co.edu.unbosque.model.persistence.VehicleDAO;
import co.edu.unbosque.util.exceptions.PlateException;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopupWindow;

public class Controller implements ActionListener {

	private MainWindow window;
	private VehicleDAO ve;
	private PopupWindow w;

	public Controller() {
		window = new MainWindow();
		ve = new VehicleDAO();
		w = new PopupWindow();
		asignarOyentes();
	}

	public void asignarOyentes() {
		window.getPshow().getBack().addActionListener(this);
		window.getRecord().getShow().addActionListener(this);
		window.getRecord().getAdd().addActionListener(this);
		window.getRecord().getRemove().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("VOLVER")) {
			window.getPshow().setVisible(false);
			window.getRecord().setVisible(true);

		}
		if (comando.equals("MOSTRAR")) {
			window.getPshow().setVisible(true);
			window.getRecord().setVisible(false);
			show();

		}
		if (comando.equals("ELIMINAR")) {
			eliminate();
		}
		if (comando.equals("AGREGAR")) {

			add();

		}

	}

	public void add() {

		boolean type = false;
		LocalTime timeCurrent = LocalTime.now();
		String vehicle = (String) window.getRecord().getCategory().getSelectedItem();
		String plate = window.getRecord().getPlate().getText();
		plate = plate.toUpperCase();

		if (vehicle.equals("Carro")) {
			type = true;
		}
		if (vehicle.equals("Moto")) {
			type = false;
		}

		try {
			PlateException.validarPlaca(plate, type);
			boolean is = ve.create(new VehicleDTO(vehicle, plate,timeCurrent));
			if (is) {
				w.informacion("Vehículo agregado exitosamente.");
			} else {

				w.informacion("Error al agregar vehículo: ya existe o la lista ya tiene 100 vehiculos");
			}
		} catch (PlateException e) {
			w.informacion("Error al agregar vehículo: " + e.getMessage());

		}

	}

	public void eliminate() {

		try {
			String plate = window.getRecord().getPlate().getText();
			plate = plate.toUpperCase();
			boolean removed = ve.eliminate(plate);
			if (removed) {
				w.informacion("Elemento eliminado exitosamente");
			} else {
				w.informacion("No se eliminó el elemento. Revise sus datos");
			}
		} catch (Exception e) {
			w.informacion("No se elimino el elemento revise sus datos");
		}
	}

	public void show() {

		window.getPshow().getShow().setText(ve.show());

	}

}
