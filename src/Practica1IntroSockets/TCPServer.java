/**
 * <p>Title: practica1</p>
 *
 * <p>Description: introduccion a los sockets</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: ESIDE</p>
 *
 * @author Unai Hernández Jayo
 * @version 1.0
 */
package Practica1IntroSockets;
import java.net.*;
import java.io.*;

public class TCPServer {

        /**
         * Metodo principal de la clase
         * @param args String[] con los parámetros de ejecución
         * @throws Exception
         */
        public static void main(String[] args) throws Exception {
        String clientSentence="";
        String mayusculasSentence="";
        try{
        	ServerSocket serverSocket = new ServerSocket (6000);
            //Se crea un serverSocket de bienvenida en el mismo puerto
            //del que se quiere escuchar al cliente
            //INTRODUCIR AQUI
            System.out.println("Esto funciona...");
            //Se accepta la petición de conexión del cliente
            //INTRODUCIR AQUI
            serverSocket.accept();
            
            while (!clientSentence.equals("adios")) 
            {
                System.out.println("Conexion establecida");
                //Lectura de la frase enviada por el cliente
                //INTRODUCIR AQUI
                //Paso de minúsculas a mayúsculas
                mayusculasSentence = clientSentence.toUpperCase();
                //Escritura en el Socket para el envio al cliente
                //INTRODUCIR AQUI
            }
        }catch(Exception e){
            System.err.println("main: " + e);
            e.printStackTrace();
        }
    }
}
