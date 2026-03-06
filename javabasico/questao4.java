//Faça um programa que descubra a quantidade exata de dias vivo que você viveu
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class questao4 {
    public static void main(String[] args)  {
        
        try (Scanner scanner = new Scanner(System.in)){
            while (true) {  
        System.out.println("Bem vindo!!");
        try {
        System.out.println("Insira sua data de nascimento (DD/MM/YYYY) :");
        String dataNascimentoStr = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        LocalDate dataAtual = LocalDate.now();

        long diasVivos = ChronoUnit.DAYS.between(dataNascimento, dataAtual);

        System.out.println("Você está vivo há " + diasVivos + " dias!");

        System.out.println("Quer descobrir de outra pessoa ?(1 para NÃO/ 2 para SIM)");
        int sn = scanner.nextInt();
        if (sn == 1) {
            System.out.println("Tchau!");
            break;}
            else  {
                continue;
            }}
            
              catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Insira a data no formato DD/MM/YYYY.");
            }
            
        }
        scanner.close();
        

    }}}
 
