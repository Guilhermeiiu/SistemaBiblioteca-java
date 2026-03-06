/* Escreva um programa em Java que peça ao usuário uma frase e verifique se nela há 
as palavras ”-help” ou ”-h”. */
import java.util.Scanner;
public class AnexoAExercicio13 {
    public static void main(String[] args){
        Scanner teclado= new Scanner(System.in);
        System.out.println("Frase:");
        String text=teclado.nextLine();
       if(text.contains("-help")|| text.contains("-h")){
        System.out.println("A frase contem esse conteudo");
       } 
       teclado.close();
    }
}
