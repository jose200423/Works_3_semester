package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Scanner;

import co.edu.unbosque.model.VehicleDAO;
import co.edu.unbosque.model.VehicleDTO;
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
		window.getPshow().getVolver().addActionListener(this);
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
			mostrar();

		}
		if (comando.equals("ELIMINAR")) {
			Eliminar();
		}
		if (comando.equals("AGREGAR")) {

			Agregar();

		}

	}

	public void Agregar() {

		boolean type = false;
		LocalTime timeCurrent = LocalTime.now();
		String carro = (String) window.getRecord().getCategory().getSelectedItem();
		String placa = window.getRecord().getPlate().getText();
		placa = placa.toUpperCase();

		if (carro.equals("Carro")) {
			type = true;
		}
		if (carro.equals("Moto")) {
			type = false;
		}

		try {
			PlateException.validarPlaca(placa, type);
			boolean esta = ve.crear(new VehicleDTO(carro, placa,timeCurrent));
			if (esta) {
				w.informacion("Vehículo agregado exitosamente.");
			} else {

				w.informacion("Error al agregar vehículo: ya existe o la lista ya tiene 100 vehiculos");
			}
		} catch (PlateException e) {
			w.informacion("Error al agregar vehículo: " + e.getMessage());

		}

	}

	public void Eliminar() {

		try {
			String placa = window.getRecord().getPlate().getText();
			placa = placa.toUpperCase();
			boolean eliminado = ve.eliminar(placa);
			if (eliminado) {
				w.informacion("Elemento eliminado exitosamente");
			} else {
				w.informacion("No se eliminó el elemento. Revise sus datos");
			}
		} catch (Exception e) {
			w.informacion("No se elimino el elemento revise sus datos");
		}
	}

	public void mostrar() {

		window.getPshow().getShow().setText(ve.mostrar());

	}

}
