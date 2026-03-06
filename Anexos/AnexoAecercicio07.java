/*Escreva um programa que calcule a área de um círculo, usando o valor constante de pi e 
o valor do raio lido do teclado.  */
import java.util.Scanner;
public class AnexoAecercicio07 {
    
    public static void main(String args[]){
        Scanner teclado= new Scanner(System.in);
    System.out.print("Raio: ");
    float raio= teclado.nextFloat();
    float pi= 3.12f;
    float area= (raio*raio)*pi;
    System.out.print("A area é: "+ area);
    }
}
