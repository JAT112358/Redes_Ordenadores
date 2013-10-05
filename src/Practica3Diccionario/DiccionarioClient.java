/*
 * @(#)DiccionarioClient.html	
 * Proyecto Diccionario remoto
 */


package Practica3Diccionario;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * La clase DiccionarioClient contiene la implementaci�n del cliente
 * con los m�todos entrar(), lista(), anadir() y salir().
 *
 */
public class DiccionarioClient {

  /** Socket por el que se realiza la comunicaci�n. */
  private Socket s;

  /** Filtro de recogida de datos del socket. */
  private BufferedReader br;

  /** Filtro de escritura de datos al socket. */
  private DataOutputStream dos;

  /**
  * Constructor de DiccionarioClient que realiza la conexi�n con la direcci�n IP suministrada.
  * @param IP Direcci�n IP del servidor de diccionario al que conectar.
  */
  public DiccionarioClient(String IP) {
    try{
        s = new Socket(IP,Diccionario.PUERTO);
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        dos = new DataOutputStream(s.getOutputStream());
    }catch(IOException ioe){
      System.err.println(ioe);
    }
  }

  /**
  * Env�a las primitivas USUARIO y CLAVE al servidor con los valores apropiados.
  * @param u Nombre del usuario con el cual conectar.
  * @param c Clave con la cual conectar.
  * @return true si se ha permitido el acceso, false en caso contrario.
  */
  public boolean entrar(String u, String c){
    try{
      dos.writeBytes("usuario " + u + "\r\n");
      System.out.println(br.readLine()); 
      dos.writeBytes("clave " + c + "\r\n");
      String r = br.readLine();
      System.out.println(r);
      if (r.startsWith("201"))
        return true;
      else
        return false;
    }catch(IOException ioe){
      System.err.println(ioe);
    }
    return false;
  }

  /**
  * Env�a la primitiva LISTA al servidor, para obtener la tabla de correspondencias del diccionario..
  * @return Un array de String con los contenidos de la tabla de correspondencias del diccionario.
  */
  public String[] lista(){
    try{
      Vector vs = new Vector();
      dos.writeBytes("lista\r\n");
      String linea = br.readLine();
      System.out.println(linea);
      for(;!linea.startsWith("202");){
        vs.addElement(linea);
        linea = br.readLine();
        System.out.println(linea);
      }
      String[] as = new String[vs.size()];
      for(int i=0;i<as.length;i++)
        as[i] = (String)vs.elementAt(i);
      return as;
    }catch(IOException ioe){
      System.err.println(ioe);
    }
    return null;
  }

  /**
  * Env�a la primitiva INCLUIR al servidor, para a�adir una palabra.
  * @param pal Palabra a a�adir.
  * @param trad Traducci�n correspondiente.
  */
  public void incluir(String pal, String trad){
    try{
      dos.writeBytes("incluir "+ pal + " " + trad + "\r\n");
      System.out.println(br.readLine());
    }catch(IOException ioe){
      System.err.println(ioe);
    }
  }

  /**
  * Env�a la primitiva SALIR al servidor y realiza la desconexi�n.
  */
  public void salir(){
    try{
      dos.writeBytes("salir\r\n");
      System.out.println(br.readLine());
      dos.close();
      br.close();
      s.close();
    }catch(IOException ioe){
      System.err.println(ioe);
    }
  }
}