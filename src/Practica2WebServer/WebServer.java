package Practica2WebServer;
import java.io.* ;
import java.net.* ;
import java.util.* ;
import util.*;

public final class WebServer
{
	public static void main(String argv[]) throws Exception
	{
		// Set the port number.
		int port = 3000;//(new Integer(argv[0])).intValue();

		ServerSocket wellcomeSocket = new ServerSocket(port);

		while (true)
		{
			//Aceptar la nueva petición y crear el SocketManager para gestionar el Socket obtenido
			//INTRODUCIR AQUI
	
			//Crear un objeto HttpRequest para gestionar la petición
			//INTRODUCIR AQUI
	
			//Crear un Thread para el objeto HttpRequest
			//INTRODUCIR AQUI
		
			//Arrancar el Thread
			//INTRODUCIR AQUI
		}
	}
}
