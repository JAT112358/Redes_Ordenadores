package Practica1IntroSockets;
import java.net.*;
import util.SocketManager;

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
            //Se crea un serverSocket de bienvenida en el mismo puerto
            //del que se quiere escuchar al cliente
            //INTRODUCIR AQUI
        	ServerSocket serverSocket = new ServerSocket (6000);
        	
            System.out.println("Esto funciona...");
            //Se accepta la petición de conexión del cliente
            //INTRODUCIR AQUI
            SocketManager socket = new SocketManager(serverSocket.accept());           
            System.out.println("Conexion establecida");
            
            while (!clientSentence.equals("adios")) 
            {
                System.out.println("Conexion establecida");
                //Lectura de la frase enviada por el cliente
                //INTRODUCIR AQUI
                clientSentence = socket.Leer();
                //Paso de minúsculas a mayúsculas
                mayusculasSentence = clientSentence.toUpperCase();
                //Escritura en el Socket para el envio al cliente
                //INTRODUCIR AQUI
                socket.Escribir(mayusculasSentence+"\n");
            }
            socket.CerrarSocket();
            serverSocket.close();
        }catch(Exception e){
            System.err.println("main: " + e);
            e.printStackTrace();
        }
    }
}
