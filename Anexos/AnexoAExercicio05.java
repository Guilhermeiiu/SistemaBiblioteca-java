/* Escreva um programa em Java que filtre uma String, de forma que a partir de uma String 
lida do teclado, o programa crie uma nova String contendo somente os valores numéricos da 
String entrada. Por exemplo, se a String entrada for ”1a2b09cd”, a String resultante 
deve ser ”1209”. Dica: você pode usar o método estático isDigit() da classe Character. */
import java.util.Scanner;
public class AnexoAExercicio05 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text= scanner.nextLine();
        int i;
        StringBuilder result = new StringBuilder();
        for(i=0;i<text.length();i++){

            if( Character.isDigit(text.charAt(i))){
               result.append(text.charAt(i));
            }
        }
        System.out.println(result);
        scanner.close();
    }
    
}
