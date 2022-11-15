package Serveur;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		ServerSocket serveurSocket = new ServerSocket(9000);
		System.out.println("J'attends la connexion ....");
		Socket socket = serveurSocket.accept();
		
		InputStream is = socket.getInputStream();
		int nombre = is.read();
		System.out.println("Le client avec l'adresse "+socket.getRemoteSocketAddress().toString()+" a envoyé "+nombre);
		nombre += 4;
		OutputStream os = socket.getOutputStream();
		System.out.println("J'envoie la reponse au client "+nombre);
		os.write(nombre);
		
		socket.close();
	}

}
