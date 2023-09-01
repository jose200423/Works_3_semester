
package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class PopupWindow {

		public PopupWindow() {
			
		}
		
		public void enseñariformacio(boolean mensaje){
			JOptionPane.showMessageDialog(null, mensaje);
		}
		
		public void mostrainformacion(int numero) {
			JOptionPane.showMessageDialog(null, numero);
		}
		public void mostrainforma(Object object) {
			JOptionPane.showMessageDialog(null, object);
			}
		
		public void informacion(String men) {
			JOptionPane.showMessageDialog(null, men);
		}
		
		public double leerDatoEntero(String mensaje) {
			double dato = 0.0;
			String aux = JOptionPane.showInputDialog(mensaje);
			dato = Double.parseDouble(aux);
			return dato;
		}
		public String leerDato(String mensaje) {
			String dato1 = "";
			String aux = JOptionPane.showInputDialog(mensaje);
			dato1 = String.valueOf(aux);
			return dato1;
		}
		
		public int leerDatoEnter(String mensa) {
			int dato = 0;
			String aux = JOptionPane.showInputDialog(mensa);
			dato = Integer.parseInt(aux);
			return dato;
		}
	}


