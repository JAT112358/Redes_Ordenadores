package Practica1IntroSockets;
import java.net.*;
import util.SocketManager;

public class TCPServer
{
    public static void main(String[] args) throws Exception 
    {
        String clientSentence="";
        String mayusculasSentence="";
        try{
            //Se crea un serverSocket de bienvenida en el mismo puerto
            //del que se quiere escuchar al cliente
        	ServerSocket serverSocket = new ServerSocket (6000);
            System.out.println("Esto funciona...");
            
            //Se accepta la petición de conexión del cliente
            SocketManager socket = new SocketManager(serverSocket.accept());           
            
            while (!clientSentence.equals("adios")) 
            {
                System.out.println("Conexion establecida");
                //Lectura de la frase enviada por el cliente
                clientSentence = socket.Leer();
               
                //Paso de minúsculas a mayúsculas
                mayusculasSentence = clientSentence.toUpperCase();
                
                //Escritura en el Socket para el envio al cliente
                socket.Escribir(mayusculasSentence+"\n");
            }
            socket.CerrarStreams();
            socket.CerrarSocket();
            serverSocket.close();   
        }
        catch(Exception e)
        {
            System.err.println("main: " + e);
            e.printStackTrace();
        }
    }
}
