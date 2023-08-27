package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private Record record;
	private Show pshow;

	public MainWindow() {
		// TODO Auto-generated constructor stub

		setTitle("Titan Plaza Parking");
		setSize(800, 800);// x, y
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		//
		inicialozarComponentes();

		setResizable(false);// no permite modificar el tamaño de la ventana
		setLocationRelativeTo(null);// lugar donde sale la ventana null en la mitad
		setVisible(true);// lebol etiquetas informacion
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titan.png")).getImage());
	}

	public void inicialozarComponentes() {

		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		record = new Record();
		getContentPane().add(record, c);
		
		pshow = new Show();
		getContentPane().add(pshow,c);
		
		

	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Show getPshow() {
		return pshow;
	}

	public void setPshow(Show pshow) {
		this.pshow = pshow;
	}

}
