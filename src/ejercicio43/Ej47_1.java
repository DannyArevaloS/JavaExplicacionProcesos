package ejercicio43;

import java.util.*;
import java.io.*;

public class Ej47_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe tu nombre");
		String nombre = sc.nextLine();
		System.out.println("Tu nombre es " + nombre);
		// este es el proceso hijo en que se pide basicamente que se escriba el nombre y este no se va a pedir aqui sino en el otro proceso padre.
	}

}
