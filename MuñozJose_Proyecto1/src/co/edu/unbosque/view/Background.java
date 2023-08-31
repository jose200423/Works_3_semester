package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JPanel{
	
	private JLabel fondo;
	
	public Background() {

		setLayout(new GridLayout());

		inicializarComponentes();

		setVisible(true);

	}
	
	/**
	 * metodo indica a cada uno de los componentes una pocion en el panel gracias al layout.
	 *
	 */

	private void inicializarComponentes() {

		ImageIcon im = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
		Image imagenOriginal = im.getImage();

		int nuevoAncho = 900;
		int nuevoAlto = (nuevoAncho * imagenOriginal.getHeight(null)) / imagenOriginal.getWidth(null);
		Image imagenEscalada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

		fondo = new JLabel();
		fondo.setIcon(new ImageIcon(imagenEscalada));

		// Configurar el tamaño preferido del JLabel (ajustar al contenedor)
		fondo.setPreferredSize(new Dimension(nuevoAncho, nuevoAlto));

		// Usar un Layout Manager apropiado para el contenedor
		setLayout(new BorderLayout());
		add(fondo, BorderLayout.CENTER);

		// Liberar recursos del ImageIcon original si ya no lo necesitas
		

	}


}
