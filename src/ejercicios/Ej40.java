package ejercicios;
import java.io.*;
public class Ej40 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.Ej40_1");
		//se utiliza el objeto ProcessBuilder al que se le pasa por parametro el tipo de archivo "java" y la direccion del archivo como lo es "ejercicios.Ej40_1" que es donde se encuentra el archivo en el paquete ejercicios y el nombre: Ej40_1 (archivo hijo) 
		pb.directory(new File(".\\bin"));
		// en la parte de bin es donde se guarda la info del jdk.
		pb.redirectErrorStream(false);
		//con este metodo lo que se busca es que se controle el error del hijo
		Process p = null;
		//se inicializa un objecto Process llamada p en vacío-
		try {
			p=pb.start();
			//se inicializa el process builder con el metodo start() y se lo guarda en el objeto process
			p.waitFor();
			//con este metodo waitFor lo que se busca es que realmente espere a que se jecute el proceso del hijo
			if(p.exitValue() !=0)
				System.out.println("Error" + p.exitValue());
			//esta buscando el error llamando que si el valor de salida del Process es diferente a cero se pinta un error en el codigo
			InputStream is = p.getInputStream();
			//leemos caracter a caracter
			int c;
			//con c inicializamos un contador
			while((c=is.read()) != -1)
				System.out.println((char)c);
			//aqui pasa que si se cumple la condicion de que el contador es igual al dato que se lee y este es diferente a -1 se retorna caracter a caracter lo del hijo
			
		}catch(Exception e) {
			e.printStackTrace();
			//aqui se recoge la excepcion del catch de tipo Exception utilizando el metodo printStackTrace()
		}
		//se realiza un try-catch para controlar los errores que se pueden estar gestionando en el codigo
		
		//lo que se busca en este codigo es que realmente este proceso padre pueda traer la ejecucion del proceso hijo.
		

	}

}
