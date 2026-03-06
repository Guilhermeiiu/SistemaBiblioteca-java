/* Escreva um programa em Java que declare e inicialize um vetor de booleanos (lendo-os 
do teclado), e calcule quantos elementos são iguais a true.  */

    import java.util.Scanner;

    public class AnexoAExercicio11{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        boolean[] vetor = new boolean[tamanho];
        
        int contadorTrue = 0;
        
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Digite true ou false para a posição " + i + ": ");
            vetor[i] = scanner.nextBoolean();
            if (vetor[i]) {
                contadorTrue++;
            }
        }
        
        System.out.println("Quantidade de elementos true: " + contadorTrue);
        scanner.close();
    }
}

