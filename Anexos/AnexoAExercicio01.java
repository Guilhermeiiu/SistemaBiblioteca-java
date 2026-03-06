//Escreva um programa em Java que peça ao usuário que digite uma String, e só aceite Strings 
//cujo comprimento seja maior ou igual a 10 caracteres.//
import java.util.Scanner;
public class AnexoAExercicio01 {

    public static void main(String[] args){ 
Scanner scanner= new Scanner(System.in);
 System.out.println("Digite algo:");
 String resposta=scanner.nextLine();
 if(resposta.length()>=10){
    System.out.println("Tamanho Aceito!!");

 }
 else{
    System.out.println("Tamanho ERRADO");

 }
 scanner.close();

    }
}

