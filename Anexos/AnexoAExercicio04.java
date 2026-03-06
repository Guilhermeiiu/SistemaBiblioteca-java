/*Escreva um programa em Java que leia uma String do teclado e troque todas as vogais 
não acentuadas da String pelo caracter ’?’. */
import java.util.Scanner;
public class AnexoAExercicio04 {
    public static void main(String[] args) {
     Scanner scanner= new Scanner(System.in);
    String text= scanner.nextLine();
    String result=text.replaceAll("[aeiouAEIOU]", "?");
    System.out.println(result);
    scanner.close();
    }
    
}
