package Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private String mom;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("127.0.0.1",9000);
		System.out.println("J'envoie une requête vers le serveur...");
		
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		System.out.println("Entrez un nombre : ");
		Scanner scanner = new Scanner(System.in);
		int nombre = scanner.nextInt();
		System.out.println("J'envoie le nombre "+nombre+" au serveur");
		os.write(nombre);
		
		int reponse = is.read();
		System.out.println("La reponse du serveur : "+reponse);
		
		socket.close();

	}

}
