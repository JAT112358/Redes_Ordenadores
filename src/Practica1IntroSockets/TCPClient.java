package Practica1IntroSockets;

import java.net.*;
import java.io.*;

/**
 * <p>Title: practica1</p>
 *
 * <p>Description: Introduccion a los sockets</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: ESIDE</p>
 *
 * @version 1.0
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        String sentence=""; //Variable dnd se almacena la frase introducida por el usuario
        String modifiedSentence=""; //Variable dnd se recibe la frase capitalizada
        try {
            //Se crea el socket, pasando el nombre del servidor y el puerto de conexión
        	//INTRODUCIR AQUI
            //Se inicializan los streams de lectura y escritura del socket
            //Se declara un buffer de lectura del
            //dato escrito por el usuario por teclado
            //es necesario pq no es un buffer propio de los sockets
        	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            //Se almacena en "sentence" la linea introducida por teclado

            while (!sentence.equals("adios")) {
                System.out.print("String a enviar: ");
                sentence = inFromUser.readLine();
                //El método Escribir, pone en el socket lo introducido por teclado
                //INTRODUCIR AQUI
                //El método Leer, lee del socket lo enviado por el Servidor
                //INTRODUCIR AQUI 
                //Saca por consola la frase modificada enviada por el servidor
                //INTRODUCIR AQUI
            }
            System.out.println("Fin de la práctica");
            //INTRODUCIR AQUI
        } catch (Exception e) {
			System.err.println("main: " + e);
			e.printStackTrace();
        }

    }
    }
