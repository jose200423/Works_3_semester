package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

	private static File archivo;
	private static Scanner lector;
	private static PrintWriter escritor;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;

	public FileHandler() {
	}

	public static String leerArchivo(String filename) {
		StringBuilder sb = new StringBuilder();
		archivo = new File("src/co/edu/unbosque/model/persistence/" + filename);
		try {
			lector = new Scanner(archivo);
			while (lector.hasNext()) {
				sb.append(lector.nextLine()+"\n");
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe.");
		} catch (IOException e) {
			System.err.println("No tiene los permisos para acceder al archivo.");
		}
		return sb.toString();
	}

	public static void escribirArchivo(String filename, String content) {
		archivo = new File("src/co/edu/unbosque/model/persistence/" + filename);
		try {
			escritor = new PrintWriter(archivo);
			escritor.print(content);
			escritor.close();
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no se ha encontrado.");
		} catch (IOException e) {
			System.err.println("No tiene los permisos para acceder al archivo.");
		}
	}

	public static Object leerSerializado(String filename) {
		try {
			ois = new ObjectInputStream(new FileInputStream("src/co/edu/unbosque/model/persistence/" + filename));
			Object obj = ois.readObject();
			return obj;
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no se ha encontrado.");
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			System.err.println("Error al leer archivo(serializado).");
		}
		return null;
	}

	public static void escribirSerializado(String filename, Object obj) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream("src/co/edu/unbosque/model/persistence/" + filename));
			oos.writeObject(obj);
			oos.close();
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no se ha encontrado.");
		} catch (IOException e) {
			System.err.println("Error al serialisar el objeto");
		}
	}

	public static File getArchivo() {
		return archivo;
	}

	public static void setArchivo(File archivo) {
		FileHandler.archivo = archivo;
	}

	public static Scanner getLector() {
		return lector;
	}

	public static void setLector(Scanner lector) {
		FileHandler.lector = lector;
	}

	public static PrintWriter getEscritor() {
		return escritor;
	}

	public static void setEscritor(PrintWriter escritor) {
		FileHandler.escritor = escritor;
	}

	public static ObjectInputStream getOis() {
		return ois;
	}

	public static void setOis(ObjectInputStream ois) {
		FileHandler.ois = ois;
	}

	public static ObjectOutputStream getOos() {
		return oos;
	}

	public static void setOos(ObjectOutputStream oos) {
		FileHandler.oos = oos;
	}
	
	

}
