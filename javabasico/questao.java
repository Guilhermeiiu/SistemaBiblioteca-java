import java.util.Scanner;

public class questao {

    public static void main (String[] args){

Scanner scanner = new Scanner(System.in);

//Construir um programa que armazene um valor numérico inteiro e
//apresente como resultado os seus valores sucessor e antecessor
while (true) {
  


System.out.println("Digite seu número");
int numeroInicial = scanner.nextInt();

int suce = numeroInicial + 1;
int antece = numeroInicial -1;

System.out.println("O valor sucessor de seu numero é:  " +  suce  +  ". E o antecessor é:  " +  antece) ;
        System.out.println("Você que tentar com outro valor digite 1");
        int sin = scanner.nextInt();
        if (sin == 1){
          continue;
        }
        else{System.out.println("Tchau!");break;}

   } scanner.close(); 
}} 