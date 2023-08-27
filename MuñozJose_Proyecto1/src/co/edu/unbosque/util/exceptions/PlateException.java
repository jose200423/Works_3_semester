package co.edu.unbosque.util.exceptions;

public class PlateException extends Exception {

	private String message;

	public PlateException(String message) {
		super();
		this.message = message;
	}

	public static void validarPlaca(String placa, boolean isCar) throws PlateException{
		if (isCar) {
            if (!placa.matches("^[A-Z]{3}\\d{3}$")) {
                throw new PlateException("La placa del carro no cumple con el formato requerido "+"\n" +"(3 letras seguidas de 3 números).");
            }
        } else {
            if (!placa.matches("^[A-Z]{3}\\d{2}[A-Z]$")) {
                throw new PlateException("La placa de la moto no cumple con el formato requerido"+"\n"+"(3 letras, 2 números y 1 letra).");
            }
        }
    }


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
