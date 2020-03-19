/*-----------------------------------------------------------------------*/
/* 						Project Iedrys Version 3						 */
/* Find the newest version in https://github.com/Miraneel/Project-Iedrys */
/*-----------------------------------------------------------------------*/

//Christopher Gabriel Pedraza Pohlenz

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraModular {

	//ATRIBUTOS
	private static FileWriter fw = null;
	private static PrintWriter pw = null;
	private static File archivo = null;
	private static FileReader fr = null;
	private static BufferedReader br = null;
	private static String linea;



	public void setDireccionEsc(String pDireccion, Boolean pConservar) throws IOException {
		fw = new FileWriter(pDireccion, pConservar);
	}

	public void setDireccionLec(String pDireccion) throws IOException {
		archivo = new File(pDireccion);
	}



	//LEER Y ESCRIBIR
	public String Leer() throws IOException{
		linea = br.readLine();
		return linea;
	}

	public void Escribir(String pTexto) throws IOException {
		pw.println(pTexto);
	}



	//INSTANCIAS
	public void InstanciaEsc() {
		pw = new PrintWriter(fw);
	}

	public void InstanciaLec() throws IOException {
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);	
	}



	//CERRAR
	public void CerrarEsc() throws IOException {
		fw.close();
	}

	public void CerrarLec() throws IOException {
		fr.close();
	}



	//CONTAR
	public int Contar(String pDireccion) throws IOException {
		fw = new FileWriter(pDireccion, true);
		fw.close();

		archivo = new File(pDireccion);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);

		String temporal = "";

		int contador = -1;

		while (temporal != null) {
			temporal = br.readLine();
			contador++;
		}

		fr.close();
		return contador;
	}



	//LISTAR CON CONTADOR
	public void ListarConContador(String pDireccion) throws IOException {
		fw = new FileWriter(pDireccion, true);
		fw.close();

		archivo = new File(pDireccion);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);

		int contador = 0;
		String temporal = "";

		while (temporal != null) {
			temporal = br.readLine();
			contador++;
			if (temporal != null) {
				System.out.println(contador + ". " + temporal);
			}
		}

		fr.close();
	}



	//LISTAR
	public void Listar(String pDireccion) throws IOException {
		fw = new FileWriter(pDireccion, true);
		fw.close();

		archivo = new File(pDireccion);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);

		String temporal = "";

		while (temporal != null) {
			temporal = br.readLine();
			if (temporal != null) {
				System.out.println(temporal);
			}
		}

		fr.close();
	}



	//AGREGAR
	public void Agregar(String pDireccion, boolean pConservar, String pTexto) throws IOException {
		fw = new FileWriter(pDireccion, pConservar);
		pw = new PrintWriter(fw);
		pw.println(pTexto);
		fw.close();	
	}



	//ELIMINAR
	public void Eliminar(String pDireccion, int pIndice) throws IOException {
		int tempNum = pIndice - 1;
		String temporal = "";

		fw = new FileWriter(pDireccion, true);
		fw.close();

		int cantidad = Contar(pDireccion);
		String arreglo[] = new String [cantidad];

		archivo = new File(pDireccion);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);

		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = br.readLine();
		}

		fr.close();

		fw = new FileWriter(pDireccion, false);
		pw = new PrintWriter(fw);

		for (int i = 0; i < cantidad; i++) {
			if (i != tempNum) {
				temporal = arreglo[i];
				pw.println(temporal);
			}
		}

		fw.close();	
	}



	//MODIFICAR
	public void Modificar(String pDireccion, int pIndice, String pTexto) throws IOException {
		int tempNum = pIndice - 1;
		String temporal = "";

		fw = new FileWriter(pDireccion, true);
		fw.close();

		int cantidad = Contar(pDireccion);
		String arreglo[] = new String [cantidad];

		archivo = new File(pDireccion);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);

		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = br.readLine();
		}

		fr.close();

		fw = new FileWriter(pDireccion, false);
		pw = new PrintWriter(fw);

		for (int i = 0; i < cantidad; i++) {
			if (i != tempNum) {
				temporal = arreglo[i];
				pw.println(temporal);
			}
			else {
				pw.println(pTexto);
			}
		}

		fw.close();	
	}



	//ARCHIVO A ARREGLO
	public String[] fileToArray(String pDireccion) throws IOException {
		int contador = Contar(pDireccion);
		contador--;

		String arreglo[] = new String[contador];

		archivo = new File(pDireccion);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);

		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = br.readLine();
		}

		fr.close();

		return arreglo;
	}



	//ARCHIVO EXISTE
	public boolean fileExists(String pDireccion) {
		File tempFile = new File(pDireccion);
		boolean exists = tempFile.exists();
		return exists;
	}
}

//Christopher Pedraza Pohlenz A01177767