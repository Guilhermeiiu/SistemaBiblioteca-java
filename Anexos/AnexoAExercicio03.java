/*Escreva um programa em Java que receba uma String e um valor numérico N do teclado, e 
imprima somente os primeiros N caracteres da String. O programa deve verificar se N é 
um valor válido (menor que o comprimento da String).*/
import java.util.Scanner;
public class AnexoAExercicio03 {
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
   String resp= scanner.nextLine();
   int cont= scanner.nextInt();
   int i;
   if (cont > 0 && cont <= resp.length()) { 
    String result = resp.substring(0, cont); 
    System.out.println("Resultado: " + result);
} else {
    System.out.println("Tamanho de N inválido.");
}
   scanner.close();
    }}
    

