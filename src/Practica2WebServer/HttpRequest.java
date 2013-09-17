package Practica2WebServer;

import java.io.*;
import java.net.*;
import java.util.*;
import util.*;

final class HttpRequest implements Runnable {

  final static String CRLF = "\r\n";
  SocketManager sockManager;

  // Constructor
  public HttpRequest(SocketManager sockMan) throws Exception {
    sockManager = sockMan;
  }

  // Implement the run() method of the Runnable interface.
  public void run() {
    try {
      processRequest();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  private void processRequest() throws Exception {
    // Get the request line of the HTTP request message.
    String requestLine = sockManager.Leer();
    System.out.println("RequestLine: " + requestLine);

    // Extract the filename from the request line.
    StringTokenizer tokens = new StringTokenizer(requestLine);
    tokens.nextToken(); // skip over the method, which should be "GET"
    //System.out.println("Next Token: "+tokens.nextToken());
    String fileName = tokens.nextToken();
    fileName = "archivos/" + fileName;
    // Open the requested file.
    FileInputStream fis = null;
    boolean fileExists = true;
    try {
      fis = new FileInputStream(fileName);
    }
    catch (FileNotFoundException e) {
      fileExists = false;
      System.out.println("No abre fichero");
    }

    System.out.println("Incoming!!!");
    System.out.println("1.............." + requestLine);

    // Get and display the header lines.
    String headerLine = null;
    while ( (headerLine = sockManager.Leer()).length() != 0) {
      System.out.println("2.............." + headerLine);
    }

    // Construct the response message.
    String statusLine = null;
    String contentTypeLine = null;
    String entityBody = null;
    if (fileExists) {
      //statusLine = INTRODUCIR AQUI;
      //contentTypeLine = INTRODUCIR AQUI usando la función contentType que os doy implementada;
    }
    else {
      //StatusLine = INTRODUCIR AQUI;
      //contentTypeLine = INTRODUCIR AQUI;
      entityBody = "<HTML>" + "<HEAD><TITLE>Not Found</TITLE></HEAD>" + "<BODY>Not Found</BODY></HTML>";
     }

    // Send the status line.
    //INTRODUCIR AQUI

    // Send the content type line.
    //INTRODUCIR AQUI

    // Send a blank line to indicate the end of the header lines.
    //INTRODUCIR AQUI

    // Send the entity body.
    if (fileExists) {
      sendBytes(fis);
      fis.close();
    }
    else {
      //INTRODUCIR AQUI
    }

    // Close streams and socket.
    sockManager.CerrarStreams();
    sockManager.CerrarSocket();
  }

  private void sendBytes(FileInputStream fis) throws Exception {
    // Construct a 1K buffer to hold bytes on their way to the socket.
    byte[] buffer = new byte[1024];
    int bytes = 0;

    // Copy requested file into the socket's output stream.
    //INTRODUCIR AQUI
   }

  private static String contentType(String fileName) {
    if (fileName.endsWith(".htm") || fileName.endsWith(".html")) {
      return "text/html";
    }
    if (fileName.endsWith(".ram") || fileName.endsWith(".ra")) {
      return "audio/x-pn-realaudio";
    }
    return "application/octet-stream";
  }
}
