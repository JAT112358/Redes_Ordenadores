package Practica1IntroSockets;
import java.net.*;
import java.io.*;

import util.SocketManager;


public class TCPClient 
{
    public static void main(String[] args) throws Exception 
    {
        String sentence=""; 		//Variable dnd se almacena la frase introducida por el usuario
        String modifiedSentence=""; //Variable dnd se recibe la frase capitalizada
        try {
            //Se crea el socket, pasando el nombre del servidor y el puerto de conexión
        	SocketManager clientSocket = new SocketManager(new Socket("127.0.0.1", 6000));
            
    		//Se declara un buffer de lectura del
            //dato escrito por el usuario por teclado
            //es necesario pq no es un buffer propio de los sockets
        	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            
            while (!sentence.equals("adios")) 
            {
                System.out.print("String a enviar: ");
                sentence = inFromUser.readLine();
              
                //El método Escribir, pone en el socket lo introducido por teclado
                clientSocket.Escribir(sentence+"\n");
               
                //El método Leer, lee del socket lo enviado por el Servidor
                modifiedSentence = clientSocket.Leer();
                
                //Saca por consola la frase modificada enviada por el servidor
                System.out.println("Frase mayusculas: "+modifiedSentence);
            }
            System.out.println("Fin de la práctica");
            clientSocket.CerrarStreams();
            clientSocket.CerrarSocket();
        } 
        catch (Exception e) 
        {
			System.err.println("main: " + e);
			e.printStackTrace();
        }
    }
}