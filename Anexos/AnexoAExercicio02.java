//Escreva um programa em Java que leia uma String do teclado e imprima seus caracteres, um 
//por um.

import java.util.Scanner;
public class AnexoAExercicio02 {

    public static void main(String[] args){ 
        Scanner scanner=new Scanner(System.in);
        String resp= scanner.nextLine();
        int i;
        for(i=0;i<resp.length();i++){
            System.out.println(resp.charAt(i));

        }
        scanner.close();
}}