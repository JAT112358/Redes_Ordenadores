package Practica2WebServer;
import java.net.* ;
import util.*;

public final class WebServer
{
	public static void main(String argv[]) throws Exception
	{
		// Set the port number.
		int port = 3000;//(new Integer(argv[0])).intValue();
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Servidor inicializado en el puerto "+port);
		
		while (true)
		{
			//Aceptar la nueva petición y crear el SocketManager para gestionar el Socket obtenido
			SocketManager clientSocket = new SocketManager(serverSocket.accept());
			
			//Crear un objeto HttpRequest para gestionar la petición
			HttpRequest httprequest = new HttpRequest(clientSocket);
			
			//Crear un Thread para el objeto HttpRequest
			Thread clientThread = new Thread(httprequest);
			
			//Arrancar el Thread
			clientThread.start();
		}
	}
}