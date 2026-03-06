import java.util.Scanner;

public class VerificacaoChequeEspecial { 

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 

        double saldo = scanner.nextDouble(); 
        double saque = scanner.nextDouble(); 
        double limiteChequeEspecial = 500; 

        
        if(saque<=saldo){
          System.out.println("Transação realizada com sucesso.");
        }
        else if (saldo<saque && saldo+limiteChequeEspecial >= saque){
          System.out.println("Transação realizada com sucesso utilizando o cheque especial.");
        }
        else{
System.out.println("Transação não realizada. Limite do cheque especial excedido.");
           

          
                System.out.println("Transacao nao realizada. Limite do cheque especial excedido.");
            }
            scanner.close(); }

// Fechamos o objeto Scanner para liberar os recursos:
        
    }
