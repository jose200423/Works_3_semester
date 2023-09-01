package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Show extends JPanel {

	private JTextArea show;
	private JLabel title;
	private JButton back;
	private Background in;

	/**
	 * metodo constructor de la clase Menu inicia un layout, un fonfo, inicializa los componentes del
	 * otro metodo y decide si es visible o no el panel.
	 *
	 */	
	
	

	
	
	
    public Show() {
		
    	setLayout(new BorderLayout()); //diseño 
		setBackground(Color.WHITE);
		setBorder(new TitledBorder("Placas"));
		
		inicializarComponentes();
		
		setVisible(false);
	}

	public void inicializarComponentes() {
		
		Font ti = new Font("Arial Black", 50, 50);
		Font button = new Font("Arial Black", 30, 20);

		show = new JTextArea();
		show.setBounds(50, 50, 585, 400);
		show.setEditable(true);// configuracion si se puede escribir
		show.setFont(button);
		show.setBackground(Color.white);
		show.setForeground(Color.BLACK);
		JScrollPane pscroll = new JScrollPane(show, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(pscroll, BorderLayout.CENTER);
		
		back = new JButton("Volver");
		back.setFont(button);
		back.setBackground(Color.lightGray);
		back.setForeground(Color.BLACK);
		back.setBounds(275, 470, 150, 40);
		back.setActionCommand("VOLVER");
		add(back, BorderLayout.SOUTH);
	}

	public JTextArea getShow() {
		return show;
	}

	public void setShow(JTextArea show) {
		this.show = show;
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton volver) {
		this.back = volver;
	}

	public Background getIn() {
		return in;
	}

	public void setIn(Background in) {
		this.in = in;
	}
	
}
