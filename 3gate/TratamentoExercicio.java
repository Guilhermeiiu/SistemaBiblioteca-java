import java.util.InputMismatchException;
import java.util.Scanner;

public class TratamentoExercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;

        while (true) {
            try {
                System.out.print("Digite um número inteiro: ");
                numero = scanner.nextInt();
                break; // sai do loop se não der erro
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // limpa o buffer
            }
        }

        System.out.println("Você digitou: " + numero);
        scanner.close();
    }
}
