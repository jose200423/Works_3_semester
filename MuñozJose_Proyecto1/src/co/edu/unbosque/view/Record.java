package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.persistence.*;

public class Record extends JPanel{
	
	private JTextField type;
	private JTextField plate;
	private JLabel title;
	private JLabel titlesec;
	private JLabel titletre;
	private JButton add;
	private JButton remove;
	private JButton show;
	private Background in;
	private JComboBox<String> category;
	
	/**
	 * metodo constructor de la clase Menu inicia un layout, un fonfo, inicializa los componentes del
	 * otro metodo y decide si es visible o no el panel.
	 *
	 */	
	
	
	public Record() {
		
		setLayout(new GridBagLayout());
		
		//setForeground(Color.GREEN);
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	
	
	/**
	 * metodo indica a cada uno de los componentes una pocion en el panel gracias al layout.
	 *
	 */
	
	public void inicializarComponentes() {
		
		GridBagConstraints c = new GridBagConstraints();
		Font ti = new Font("Arial Black", 50, 50);
		Font button = new Font("Arial Black", 50, 30);
		
		title = new JLabel("Parqueadero Titan Plaza");
		title.setFont(ti);
		title.setForeground(Color.black);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 0;
		c.gridheight=1;
		c.weightx=1;
		c.weighty=1;
		add(title,c);
		
		titlesec = new JLabel("Tipo");
		titlesec.setFont(button);
		titlesec.setForeground(Color.black);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight=1;
		c.weightx=1;
		c.weighty=1;
		add(titlesec,c);
		
		type = new JTextField(" ");
		type.setFont(button);
		type.setBackground(Color.white);
		type.setForeground(Color.BLACK);
		c.gridx = 1;// fila
		c.gridy = 1;//columna
		c.gridwidth = 1;// cantidad que ocupa
		c.gridheight=1;
		c.weightx=0; //espacio adicional alguien tiene incinerate eternal 
		c.weighty=0;
		c.ipadx=200;
		c.ipady=0;
		category = new JComboBox<String>();
		category.setFont(button);
		category.setBackground(Color.white);
		category.setForeground(Color.BLACK);
		category.addItem("");
		String opciones =  FileHandler.leerArchivo("vehiculo.txt");
		String[] lineas = opciones.split("\n");
		for (String linea : lineas) { 
			category.addItem(linea);
			
		}
		add(category,c);
		
		
		titletre = new JLabel("        Placa");
		titletre.setFont(button);
		titletre.setForeground(Color.black);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight=1;
		c.weightx=1;
		c.weighty=1;
		add(titletre,c);
		
		plate = new JTextField("");
		plate.setFont(button);
		plate.setBackground(Color.white);
		plate.setForeground(Color.BLACK);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight=1;
		c.weightx=0;
		c.weighty=1;
		c.ipadx=300;
		c.ipady=0;
		add(plate,c);
		
		add = new JButton("Agregar");
		add.setActionCommand("AGREGAR");
		add.setFont(button);
		add.setBackground(Color.white);
		add.setForeground(Color.BLACK);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight=1;
		c.weightx=1;
		c.weighty=1;
		c.insets = new Insets(10, 10, 10, 10);
		add(add,c);
		
		remove = new JButton("Eliminar");
		remove.setActionCommand("ELIMINAR");
		remove.setFont(button);
		remove.setBackground(Color.white);
		remove.setForeground(Color.BLACK);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight=1;
		c.weightx=1;
		c.weighty=1;
		c.insets = new Insets(10, 10, 10, 10);
		add(remove,c);
		
		show = new JButton("Mostrar");
		show.setActionCommand("MOSTRAR");
		show.setFont(button);
		show.setBackground(Color.white);
		show.setForeground(Color.BLACK);
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight=1;
		c.weightx=1;
		c.weighty=1;
		add(show,c);
		
		in = new Background();
		in.setOpaque(false);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 4;
		c.fill = GridBagConstraints.BOTH;
		add(in,c);
		
	}



	public JTextField getType() {
		return type;
	}



	public void setType(JTextField type) {
		this.type = type;
	}



	public JTextField getPlate() {
		return plate;
	}



	public void setPlate(JTextField plate) {
		this.plate = plate;
	}



	public JLabel getTitle() {
		return title;
	}



	public void setTitle(JLabel title) {
		this.title = title;
	}



	public JLabel getTitlesec() {
		return titlesec;
	}



	public void setTitlesec(JLabel titlesec) {
		this.titlesec = titlesec;
	}



	public JLabel getTitletre() {
		return titletre;
	}



	public void setTitletre(JLabel titletre) {
		this.titletre = titletre;
	}



	public JButton getAdd() {
		return add;
	}



	public void setAdd(JButton add) {
		this.add = add;
	}



	public JButton getRemove() {
		return remove;
	}



	public void setRemove(JButton remove) {
		this.remove = remove;
	}



	public JButton getShow() {
		return show;
	}



	public void setShow(JButton show) {
		this.show = show;
	}



	public Background getIn() {
		return in;
	}



	public void setIn(Background in) {
		this.in = in;
	}



	public JComboBox<String> getCategory() {
		return category;
	}



	public void setCategory(JComboBox<String> category) {
		this.category = category;
	}
	
	

}
