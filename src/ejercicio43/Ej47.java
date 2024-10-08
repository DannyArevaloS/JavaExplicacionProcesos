package ejercicio43;

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;

public class Ej47 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("java","ejercicio43.Ej47_1");
		//se realiza la misma accion se crea un objeto ProcessBuilder llamado pb al que se le pasa por parametro el tipo de archivo que se busca como lo es .java y tambien la direccion donde buscar dicho archivo como es el paquete ejercicio47 y el archivo Ej47_1.java
		pb.directory(new File(".\\bin"));
		// en la parte de bin es donde se guarda la info del jdk.
		pb.redirectErrorStream(true);
		// aqui es donde se busca el error en el hijo como lo he explicacdo en el Ej40
		Process p = null;
		// se inicializa un objeto Proceso vacío.
		try {
			p=pb.start();
			//se alamacena la inicializacion del proceso hijo en el objeto Process.
			OutputStream os = p.getOutputStream();
			//se lee lo que pide por consola el proceso hijo
			//el método write recibe un array de bytes
			os.write("Elena".getBytes());
			//se escribre en el elemento de consola del proceso hijo en el proceso padre 
			os.close();
			//se cierra la consola.
			p.waitFor();
			//con este metodo waitFor lo que se busca es que realmente espere a que se jecute el proceso del hijo
			InputStream is = p.getInputStream();
			//leemos carácter a caracter
			int c;
			//se inicializa el contador
			while((c=is.read()) != -1)
				System.out.print((char)c);
			//aqui pasa que si se cumple la condicion de que el contador es igual al dato que se lee y este es diferente a -1 se retorna caracter a caracter lo del hijo
		} catch (Exception e) {
			e.printStackTrace();
			//aqui se recoge la excepcion del catch de tipo Exception utilizando el metodo printStackTrace()
		}
		//se aplica lo mismo el try-catch para el control de errores.
	}
}
