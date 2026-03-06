import java.util.Scanner;

public class ControleSimplesDeSaques {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double limiteDiario;
        double saque;
        double limiteRestante;

     
        limiteDiario = scanner.nextDouble();

        for (;;) {
            
            saque = scanner.nextDouble();

            if (saque == 0) {
                System.out.println("Transacoes encerradas.");
                break;
            }

            limiteRestante = limiteDiario - saque;

            if (limiteRestante >= 0) {
                System.out.println("Saque realizado. Limite restante: " + limiteRestante);
            } else {
                System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                break;
            }
            scanner.close();}

    }
}
