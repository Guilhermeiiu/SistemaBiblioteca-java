/* Escreva um programa em Java que crie um array de Strings e o popule (através da leitura dos 
seus elementos pelo teclado). Após isto, faça com que o programa calcule e imprima quantas 
Strings tem menos do que dez caracteres. */
import java.util.Scanner;
public class AnexoAExercicio12 {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        System.out.print("Digite o tamanho do array de Strings: ");
        int tamanho = teclado.nextInt();
        teclado.nextLine(); 
        
        String[] texto = new String[tamanho];
        int contadorCurta = 0;
        
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Digite a String na posição " + i + ": ");
            texto[i] = teclado.nextLine();
            
            if (texto[i].length() < 10) {
                contadorCurta++;
            }
        }
        
        System.out.println("Quantidade de Strings com menos de 10 caracteres: " + contadorCurta);
        teclado.close();
    }


    }

