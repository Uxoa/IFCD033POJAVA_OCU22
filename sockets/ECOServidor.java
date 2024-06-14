package sockets;

import java.io.*;
import java.net.*;

public class ECOServidor {
    public static void main(String[] args) {
        // En primer lugar crearemos un objeto ServerSocket pasando como parámetro el puerto dónde queremos escuchar
        try (ServerSocket servidor = new ServerSocket(25)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");
            
            // Después se abre la conexión Socket llamando al método accept()
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado.");
            
            // Establecemos los canales de entrada salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            
            String mensaje;
            // "Escuchamos" todos los mensajes que nos lleguen y los devolvemos al cliente.
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                salida.println("ECO: " + mensaje);
                
                // Estaremos escuchando hasta que el cliente nos envíe un mensaje de "Adios"
                if (mensaje.equalsIgnoreCase("Adios")) {
                    break;
                }
            }
            
            // Finalmente cerraremos todas las conexión
            System.out.println("Cerrando conexión.");
            entrada.close();
            salida.close();
            cliente.close();
            
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
