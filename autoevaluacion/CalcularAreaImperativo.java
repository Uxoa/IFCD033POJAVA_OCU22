package autoevaluacion;

import java.util.Scanner;


public class CalcularAreaImperativo {
    public static void main(String[] args) {
    //Solicita al usuario que ingrese la longitud del rectángulo.
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Escribe la longitud de un rectángulo:");
    Double longitud = input.nextDouble();
    
    //Solicita al usuario que ingrese el ancho del rectángulo.
    System.out.println("Escribe el ancho de un rectángulo:");
    Double ancho = input.nextDouble();
    
    //Calcula el área del rectángulo utilizando la fórmula: área = longitud * ancho.
    Double area = longitud * ancho;
    
    System.out.println("El área del rectángulo es:" + longitud);
    
    }
}
