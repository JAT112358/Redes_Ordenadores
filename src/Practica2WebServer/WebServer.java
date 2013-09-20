package Practica2WebServer;
import java.net.* ;
import util.*;

public final class WebServer
{
	public static void main(String argv[]) throws Exception
	{
		// Set the port number.
		int port = 3000;//(new Integer(argv[0])).intValue();
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Servidor inicializado en el puerto "+port);
		
		while (true)
		{
			//Aceptar la nueva petición y crear el SocketManager para gestionar el Socket obtenido
			//INTRODUCIR AQUI
			SocketManager clientSocket = new SocketManager(serverSocket.accept());
			
			//Crear un objeto HttpRequest para gestionar la petición
			//INTRODUCIR AQUI
			HttpRequest httprequest = new HttpRequest(clientSocket);
			
			//Crear un Thread para el objeto HttpRequest
			//INTRODUCIR AQUI
			Thread clientThread = new Thread(httprequest);
			
			//Arrancar el Thread
			//INTRODUCIR AQUI
			clientThread.start();
		}
	}
}
