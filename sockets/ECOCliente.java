package sockets;

import java.io.*;
import java.net.*;

public class ECOCliente {
    public static void main(String[] args) {
        // En primer lugar crearemos el Socket de lado cliente pasando como parámetros la url del servidor,
        // en nuestro caso localhost ya que el servidor está alojado en nuestra propia máquina y el puerto donde está escuchando.
        try (Socket socket = new Socket("localhost", 25)) {
            System.out.println("Conectado al servidor.");
            
            // Establecemos los canales de entrada salida.
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            
            // Crearemos un stream de entrada para que el usuario pueda introducir sus mensajes por línea de comandos.
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String mensaje;
            
            while (true) {
                System.out.print("Ingrese un mensaje: ");
                mensaje = teclado.readLine();
                salida.println(mensaje);
                
                // Recibimos la respuesta del servidor
                String respuesta = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);
                
                // Finalmente cerraremos todas las conexiones cuando el usuario introduce "Adios".
                if (mensaje.equalsIgnoreCase("Adios")) {
                    break;
                }
            }
            
            System.out.println("Cerrando conexión.");
            entrada.close();
            salida.close();
            socket.close();
            
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
    }
}
